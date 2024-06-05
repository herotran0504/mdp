package miu.mdp.core

import android.content.Context

fun Context.isValid(vararg inputs: String, onValid: (Array<out String>) -> Unit) {
    if (inputs.all { it.isNotBlank() }) {
        onValid(inputs)
    } else {
        showToast("Please input valid data")
    }
}

