package com.app.democircleci.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object coroutine{
    fun<T:Any> ioThenWork(work : suspend (()-> T),callback:((T?)->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data  = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
}