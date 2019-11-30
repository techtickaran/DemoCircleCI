package com.agohra.democircleci.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(msg : String)
}