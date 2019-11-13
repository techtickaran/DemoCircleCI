package com.agohra.democircleci.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agohra.democircleci.util.coroutine
import com.agohra.democircleci.data.repo.UserRepository
import com.agohra.democircleci.data.model.Users
import kotlinx.coroutines.Job

class UsersViewModel(private val repository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<Users>>()
    private lateinit var job: Job
    val users: LiveData<List<Users>>
        get() = _users

    fun getUsers() {
        job = coroutine.ioThenWork({
            repository.getUsers()
        }, {
            _users.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
