package com.example.data.model.user

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class UserModel: RealmObject {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var email: String = ""
    var phone: String = ""
}
