package miu.mdp.assignment4.data

import miu.mdp.assignment4.model.User

object UserState {
    private var _currentUser: User? = null
    var currentUser: User?
        get() = _currentUser
        set(value) {
            _currentUser = value
        }
}