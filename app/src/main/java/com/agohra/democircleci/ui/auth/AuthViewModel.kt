package com.agohra.democircleci.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel(){

    var email:String?=null
    var password:String?=null
    var authListener:AuthListener?=null

    fun loginClick(view:View){
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Login Failed")
            return
        }
    }
}