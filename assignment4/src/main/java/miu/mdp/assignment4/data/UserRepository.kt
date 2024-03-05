package miu.mdp.assignment4.data

import android.util.Log

data class User(val name: String, val id: String, val password: String)

class UserRepository private constructor() {

    fun createAccount(user: User) {
        USERS.add(user)
        UserState.currentUser = user
    }

    fun validate(
        id: String, password: String
    ) = USERS.firstOrNull { it.id == id && it.password == password }.also {
        UserState.currentUser = it
        Log.d("USER", UserState.currentUser?.name ?: "No")
    }

    companion object {
        private val USERS = mutableListOf(
            User("hung.tran", "hung.tran@miu.edu", "1234")
        )

        fun get() = UserRepository()
    }
}

object UserState {
    private var _currentUser: User? = null
    var currentUser: User?
        get() = _currentUser
        set(value) {
            _currentUser = value
        }
}