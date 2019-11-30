package com.app.democircleci.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.democircleci.R
import com.app.democircleci.databinding.ActivityLoginBinding
import com.app.democircleci.util.toast

class LoginActivity : AppCompatActivity(),AuthListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding  = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this)
                .get(AuthViewModel::class.java)

        binding.viewModel = viewModel
        viewModel.authListener = this
    }
    override fun onStarted() {
        toast("onStarted")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {

        loginResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(msg :String) {
        toast(msg)
    }
}
