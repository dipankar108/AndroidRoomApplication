package com.dailymanager.androidroomapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dailymanager.androidroomapplication.roomdatabase.User

class MainActivity : AppCompatActivity() {
    private lateinit var mRoomViewModel: RoomViewModel
    private lateinit var button: Button
    private lateinit var userView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRoomViewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        button = findViewById(R.id.buttonid)
        userView = findViewById(R.id.rv_viewUserInfo_id)
        val userAdapter = UserAdapter()
        userView.adapter = userAdapter
        userView.layoutManager = LinearLayoutManager(this)
        button.setOnClickListener {
            mRoomViewModel.addUser(User(0, "Dipto", "Debnath", 24))
        }
        mRoomViewModel.readAllData().observe(this) { list ->
            userAdapter.setUser(list)
            userAdapter.notifyDataSetChanged()
        }
    }
}