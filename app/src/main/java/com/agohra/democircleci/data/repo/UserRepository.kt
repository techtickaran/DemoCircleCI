package com.agohra.democircleci.data.repo

import com.agohra.democircleci.data.network.ListOfUsersAPI

class UserRepository(private val api: ListOfUsersAPI): SafeApiRequest() {
    suspend fun getUsers() = apiRequest { api.getUsers() }
}