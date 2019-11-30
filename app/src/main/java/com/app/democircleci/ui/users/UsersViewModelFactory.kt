package com.app.democircleci.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.democircleci.data.repo.UserRepository

class UsersViewModelFactory(private val repository: UserRepository):ViewModelProvider.NewInstanceFactory(){


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(repository) as T
    }
}