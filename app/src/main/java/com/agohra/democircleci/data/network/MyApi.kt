package com.agohra.democircleci.data.network

import android.provider.ContactsContract
import com.agohra.democircleci.data.model.Users
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    fun userLogin(@Field("email") email: String,@Field("password") password: String ): Call<ResponseBody>

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