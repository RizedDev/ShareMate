package com.example.data.model.chat

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

open class ChatsModel: RealmObject {
    var id: String = ""
    var interlocutor: String = ""
    var messageList: RealmList<MessageModel> = realmListOf()
}