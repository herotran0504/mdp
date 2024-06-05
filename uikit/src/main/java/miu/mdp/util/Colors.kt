package miu.mdp.util

import androidx.compose.ui.graphics.Color

fun Color.Companion.parseColor(hex: String) = Color(android.graphics.Color.parseColor(hex))