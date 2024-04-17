package miu.mdp.assignment4.model

import androidx.annotation.DrawableRes

data class Category(
    @DrawableRes val icon: Int,
    val name: String
)

data class User(
    val name: String,
    val id: String,
    val password: String
)
