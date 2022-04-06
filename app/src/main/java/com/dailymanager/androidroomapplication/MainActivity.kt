package com.dailymanager.androidroomapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dailymanager.androidroomapplication.roomdatabase.User

class MainActivity : AppCompatActivity(), OnClickInterFace, View.OnClickListener {
    private lateinit var mRoomViewModel: RoomViewModel
    private lateinit var button: Button
    private lateinit var userView: RecyclerView
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRoomViewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        button = findViewById(R.id.buttonid)
        userView = findViewById(R.id.rv_viewUserInfo_id)
        val userAdapter = UserAdapter(this)
        userView.adapter = userAdapter
        userView.layoutManager = LinearLayoutManager(this)
        button.setOnClickListener(this)
        mRoomViewModel.readAllData().observe(this) { list ->
            userAdapter.setUser(list)
            userAdapter.notifyDataSetChanged()
        }
    }

    override fun onItemClick(user: User) {
        this.user = user
    }

    override fun onClick(view: View?) {
        when (view) {
            button -> {
                val dialog = BottomSheetViewHolder(User(1, "new", "new", 1), this)
                dialog.show(supportFragmentManager, "New")
            }
        }
    }
}
