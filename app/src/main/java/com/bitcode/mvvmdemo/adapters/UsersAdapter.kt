package com.bitcode.mvvmdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.mvvmdemo.R
import com.bitcode.mvvmdemo.databinding.UserViewBinding
import com.bitcode.mvvmdemo.models.User

class UsersAdapter(
    var users : ArrayList<User>
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var binding = UserViewBinding.bind(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_view, null)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = users[position]
    }
}