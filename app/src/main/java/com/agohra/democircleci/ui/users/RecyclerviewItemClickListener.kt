package com.agohra.democircleci.ui.users

import android.view.View
import com.agohra.democircleci.data.model.Users

interface RecyclerviewItemClickListener {
    fun onRecyclerItemClick(view : View, users: Users)
}