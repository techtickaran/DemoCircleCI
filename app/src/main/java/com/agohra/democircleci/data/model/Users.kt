package com.agohra.democircleci.data.model

data class Users(
        val age: Int,
        val birthday: Birthday,
        val credit_card: CreditCard,
        val email: String,
        val gender: String,
        val name: String,
        val password: String,
        val phone: String,
        val photo: String,
        val region: String,
        val surname: String,
        val title: String
)