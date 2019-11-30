package com.app.democircleci.data.network

import com.app.democircleci.data.network.responses.AuthResponse
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(@Field("email") email: String,@Field("password") password: String ): retrofit2.Response<AuthResponse>

    companion object{
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://reqres.in/api/")
                    .build()
                    .create(MyApi::class.java)

        }
    }
}