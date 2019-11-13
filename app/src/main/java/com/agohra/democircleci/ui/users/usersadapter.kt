package com.agohra.democircleci.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.agohra.democircleci.R
import com.agohra.democircleci.databinding.RawUserItemBinding
import com.agohra.democircleci.data.model.Users

class usersadapter(private val users: List<Users>) : RecyclerView.Adapter<usersadapter.UsersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            UsersViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.raw_user_item,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        holder.rawUserItemBinding.users = users[position]

    }

    override fun getItemCount() = users.size


    inner class UsersViewHolder(
            val rawUserItemBinding: RawUserItemBinding) :
            RecyclerView.ViewHolder(rawUserItemBinding.root)

}