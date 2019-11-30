package com.app.democircleci.ui.users

import android.view.View
import com.app.democircleci.data.model.Users

interface RecyclerviewItemClickListener {
    fun onRecyclerItemClick(view : View, users: Users)
}