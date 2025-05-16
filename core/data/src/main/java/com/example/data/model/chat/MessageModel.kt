package com.example.data.model.chat

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class MessageModel: RealmObject {
    var text: String = ""
    var senderId: String = ""
    var timestamp: String = ""
}