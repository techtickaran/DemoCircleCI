package com.agohra.democircleci.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.agohra.democircleci.data.repo.UserTokenRepo

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

        val loginResponse = UserTokenRepo().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}