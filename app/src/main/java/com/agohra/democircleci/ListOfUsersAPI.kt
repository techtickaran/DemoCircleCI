package com.agohra.democircleci

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ListOfUsersAPI {

    @GET("api/?amount=100")
    suspend fun getUsers(): Response<List<UsersData>>

    companion object{
        operator fun invoke():ListOfUsersAPI{
           return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://uinames.com/")
                    .build()
                    .create(ListOfUsersAPI::class.java)

        }
    }
}