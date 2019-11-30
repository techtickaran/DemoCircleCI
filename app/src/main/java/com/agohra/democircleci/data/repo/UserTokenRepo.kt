package com.agohra.democircleci.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.agohra.democircleci.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class UserTokenRepo {
    fun userLogin(email: String, password: String) :LiveData<String>{
        val loginResponse = MutableLiveData<String>()


        MyApi().userLogin(email,password)
                .enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        loginResponse.value = t.message
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if (response.isSuccessful){
                            loginResponse.value = response.body()?.string()
                        }else{
                            loginResponse.value = response.errorBody()?.string()
                        }
                    }

                })
        return loginResponse
    }
}