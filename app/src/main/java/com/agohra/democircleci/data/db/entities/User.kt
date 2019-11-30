package com.agohra.democircleci.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_TOKEN=0

@Entity
data class User(var token:String?=null){
    @PrimaryKey(autoGenerate = false)
    var userID:Int = CURRENT_TOKEN
}