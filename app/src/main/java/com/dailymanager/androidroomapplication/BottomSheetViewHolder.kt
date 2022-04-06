package com.dailymanager.androidroomapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.dailymanager.androidroomapplication.roomdatabase.User
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetViewHolder(private val user: User, private val mcontext: ViewModelStoreOwner) :
    BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottomsheetview, container, false)
        val fName: EditText = view.findViewById(R.id.et_fName_id)
        val lName: EditText = view.findViewById(R.id.et_lName_id)
        val age: EditText = view.findViewById(R.id.et_age_id)
        val submit: Button = view.findViewById(R.id.btn_submitId)

        val mRoomViewModel = ViewModelProvider(mcontext)[RoomViewModel::class.java]
        submit.setOnClickListener {
            val first = fName.text.toString()
            val last = lName.text.toString()
            var mage = 0
            try {
                mage = age.text.toString().toInt()
            } catch (e: Exception) {
            }
            if (checkValidate(first, last, mage)) {
                mRoomViewModel.addUser(User(0, first, last, mage))
                dismiss()
            } else Toast.makeText(activity, "Field Cannot be empty", Toast.LENGTH_LONG).show()
        }
        container?.addView(view)
        return view
    }

    private fun checkValidate(fName: String, lname: String, age: Int): Boolean {
        return when {
            fName.isEmpty() -> {
                false
            }
            lname.isEmpty() -> {
                false
            }
            age < 0 -> false
            else -> true
        }
    }
}