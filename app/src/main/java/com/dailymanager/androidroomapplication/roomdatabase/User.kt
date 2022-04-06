package com.dailymanager.androidroomapplication.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fName: String,
    val lName: String,
    val age: Int
)
