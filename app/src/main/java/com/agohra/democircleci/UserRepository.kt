package com.agohra.democircleci

class UserRepository(private val api:ListOfUsersAPI): SafeApiRequest() {
    suspend fun getUsers() = apiRequest { api.getUsers() }
}