package com.dailymanager.androidroomapplication

import androidx.lifecycle.LiveData
import com.dailymanager.androidroomapplication.roomdatabase.User
import com.dailymanager.androidroomapplication.roomdatabase.UserDao

class Repository(private val userDao: UserDao) {
    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun readAllData(): LiveData<List<User>> = userDao.readAllData()
}