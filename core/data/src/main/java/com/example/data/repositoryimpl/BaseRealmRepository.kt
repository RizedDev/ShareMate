package com.example.data.repositoryimpl

import com.example.data.mapper.MapperObject
import com.example.data.mapper.UserModelMapper
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.delete
import io.realm.kotlin.query.RealmQuery
import io.realm.kotlin.types.RealmObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class BaseRealmRepository<R: RealmObject, M: Any>(
    val realm: Realm,
    val mapper: MapperObject<R, M>
) {
    suspend fun addToDataBase(item: R) {
        realm.write {
            copyToRealm(item, UpdatePolicy.ALL)
        }
    }

    suspend inline fun <reified T: R> deleteFromDataBase(id: Int) {
        val itemToDelete = realm.query(T::class, "id = $0", id).find()
        realm.write {
            delete(findLatest(itemToDelete.first())!!)
        }
    }

    inline fun <reified T: R> getOnRequest(query: String, vararg args: Any?): Flow<List<M>> {
        return realm.query(T::class, query, *args).asFlow().map { result ->
            result.list.map {
                mapper.transform(it)
            }
        }
    }

    inline fun <reified T : R> getFromIdDatabase(id: Int?): Flow<M?> {
        return realm.query(T::class, "id = $0", id).find().asFlow().map { result ->
            result.list.firstOrNull()?.let { mapper.transform(it) }
        }
    }

    inline fun <reified T : R> getFromDataBase(): List<R> {
        return realm.query(T::class).find().toList()
    }

}