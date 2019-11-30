package com.app.democircleci.data.repo

import com.app.democircleci.data.network.ListOfUsersAPI

class UserRepository(private val api: ListOfUsersAPI): SafeApiRequest() {
    suspend fun getUsers() = apiRequest { api.getUsers() }
}