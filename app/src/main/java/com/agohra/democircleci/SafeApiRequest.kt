package com.agohra.democircleci

import android.webkit.ConsoleMessage
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest{
    suspend fun<T:Any> apiRequest(call : suspend() -> Response<T>): T{
        val res = call.invoke()
        if (res.isSuccessful){
            return res.body()!!
        }else{
            //TODO: API EXCEPTION HANDLE
            throw APIEXCEPTION(res.code().toString())
        }
    }
}

class APIEXCEPTION(message: String):IOException(message)