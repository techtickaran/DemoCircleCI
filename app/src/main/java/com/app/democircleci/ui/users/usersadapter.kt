package com.app.democircleci.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.democircleci.R
import com.app.democircleci.databinding.RawUserItemBinding
import com.app.democircleci.data.model.Users

class usersadapter(private val users: List<Users>,private val  listener: RecyclerviewItemClickListener) : RecyclerView.Adapter<usersadapter.UsersViewHolder>() {


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
        holder.rawUserItemBinding.profile.setOnClickListener(){
                listener.onRecyclerItemClick(holder.rawUserItemBinding.profile,users[position])
        }

    }

    override fun getItemCount() = users.size


    inner class UsersViewHolder(
            val rawUserItemBinding: RawUserItemBinding) :
            RecyclerView.ViewHolder(rawUserItemBinding.root)

}