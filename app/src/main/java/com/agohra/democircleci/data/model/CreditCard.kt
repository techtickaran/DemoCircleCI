package com.agohra.democircleci.data.model

data class CreditCard(
    val expiration: String,
    val number: String,
    val pin: Int,
    val security: Int
)