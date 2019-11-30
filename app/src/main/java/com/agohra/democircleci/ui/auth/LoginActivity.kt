package com.agohra.democircleci.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.agohra.democircleci.R
import com.agohra.democircleci.databinding.ActivityLoginBinding
import com.agohra.democircleci.util.toast

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

    override fun onSuccess() {
        toast("onSuccess")
    }

    override fun onFailure(msg :String) {
        toast(msg)
    }
}
