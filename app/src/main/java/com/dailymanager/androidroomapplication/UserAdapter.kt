package com.dailymanager.androidroomapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dailymanager.androidroomapplication.roomdatabase.User

class UserAdapter(private val listener: OnClickInterFace) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userInfoArray = listOf<User>()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fName: TextView = itemView.findViewById(R.id.tv_user_fName)
        val lName: TextView = itemView.findViewById(R.id.tv_user_lName)
        val age: TextView = itemView.findViewById(R.id.tv_userAge)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.userinfo, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val res = userInfoArray[position]
        holder.fName.text = res.fName
        holder.lName.text = res.lName
        holder.age.text = res.age.toString()
        holder.linearLayout.setOnClickListener {
            listener.onItemClick(res)
        }
    }

    override fun getItemCount() = userInfoArray.size
    fun setUser(userInfo: List<User>) {
        userInfoArray = userInfo
    }
}
