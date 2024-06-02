package miu.mdp.assignment4.data

import miu.mdp.assignment4.model.User
import javax.inject.Inject

interface UserRepository {
    fun createAccount(user: User): User?
    fun validate(id: String, password: String): User?
}

internal class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun createAccount(user: User): User? {
        if (USERS.map { it.id }.contains(user.id)) {
            return null
        }
        USERS.add(user)
        UserState.currentUser = user
        return user
    }

    override fun validate(
        id: String, password: String
    ) = USERS.firstOrNull { it.id == id && it.password == password }.also {
        UserState.currentUser = it
    }

    companion object {
        private val USERS = mutableListOf(
            User("hung.tran", "hung.tran@miu.edu", "123456")
        )
    }
}

