package com.agohra.democircleci

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

class UsersViewModel(private val repository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<UsersData>>()
    private lateinit var job: Job
    val users: LiveData<List<UsersData>>
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
