package com.dailymanager.androidroomapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dailymanager.androidroomapplication.roomdatabase.User
import com.dailymanager.androidroomapplication.roomdatabase.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: Repository
    private val readALlData: LiveData<List<User>>

    init {
        val userDao = UserDatabase.getDataBaseInstance(application).userDao()
        userRepository = Repository(userDao)
        readALlData = userRepository.readAllData()
    }

    fun readAllData() = userRepository.readAllData()
    fun addUser(user: User) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }
}