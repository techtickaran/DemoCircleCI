package com.agohra.democircleci.data.network

import com.agohra.democircleci.data.model.Users
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ListOfUsersAPI {

    @GET("api/?ext&amount=500")
    suspend fun getUsers(): Response<List<Users>>

    companion object{
        operator fun invoke(): ListOfUsersAPI {
           return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://uinames.com/")
                    .build()
                    .create(ListOfUsersAPI::class.java)

        }
    }
}