package com.example.taskaffinityapp.models
import java.io.Serializable

data class User(
    val name: String?,
    val surname: String?,
    val age: Int?,

) : Serializable

