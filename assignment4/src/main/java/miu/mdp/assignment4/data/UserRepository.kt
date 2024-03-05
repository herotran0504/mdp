package miu.mdp.assignment4.data

data class User(val name: String, val id: String, val password: String)

class UserRepository private constructor() {

    fun createAccount(user: User): User? {
        if (USERS.map { it.id }.contains(user.id)) {
            return null
        }
        USERS.add(user)
        UserState.currentUser = user
        return user
    }

    fun validate(
        id: String, password: String
    ) = USERS.firstOrNull { it.id == id && it.password == password }.also {
        UserState.currentUser = it
    }

    companion object {
        private val USERS = mutableListOf(
            User("hung.tran", "hung.tran@miu.edu", "123456")
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