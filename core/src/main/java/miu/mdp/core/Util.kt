package miu.mdp.core

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

fun Int.randElm() = Random.nextInt(this)

fun <E> MutableList<E>.randElm() = this[size.randElm()]

fun Date.formatToString(pattern: String = "dd/MM/yyyy"): String = simpleDateFormat(pattern).format(this)

fun Date.formatToReadableString(): String = formatToString("MMMM d, yyyy")

fun String.parseToDate(pattern: String = "dd/MM/yyyy"): Date = try {
    simpleDateFormat(pattern).parse(this)!!
} catch (e: ParseException) {
    e.printStackTrace()
    Date()
}

private fun simpleDateFormat(pattern: String = "dd/MM/yyyy") = SimpleDateFormat(pattern, Locale.getDefault())

