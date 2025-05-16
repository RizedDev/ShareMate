package com.example.data.model.user

import com.example.data.model.chat.ChatsModel
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class UserModel: RealmObject {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var email: String = ""
    var phone: String = ""
    var chats: RealmList<ChatsModel> = realmListOf()
}
