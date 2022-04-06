package com.dailymanager.androidroomapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailymanager.androidroomapplication.roomdatabase.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var userInfoArray = listOf<User>()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.userinfo, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

    }

    override fun getItemCount() = userInfoArray.size
    fun setUser(userInfo: List<User>) {
        userInfoArray = userInfo
    }
}
