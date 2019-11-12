package com.agohra.democircleci

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

object coroutine{
    fun<T:Any> ioThenWork(work : suspend (()-> T),callback:((T?)->Unit)) =

        CoroutineScope(Dispatchers.Main).launch {

            val data  = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }


}