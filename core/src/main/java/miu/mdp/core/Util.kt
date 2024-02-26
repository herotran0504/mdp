package miu.mdp.core

import kotlin.random.Random

fun Int.randElm() = Random.nextInt(this)

fun <E> MutableList<E>.randElm() = this[size.randElm()]