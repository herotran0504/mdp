package miu.mdp.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.WindowManager.LayoutParams
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker

@Suppress("DEPRECATION")
fun Activity.hideSystemBar() {
    window.apply {
        clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        statusBarColor = Color.TRANSPARENT
    }
}

fun Activity.hideKeyboard() {
    findViewById<View>(android.R.id.content)?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun showForwardDatePicker(fragmentManager: FragmentManager, callback: (Long) -> Unit) {
    showDatePicker(fragmentManager, DateValidatorPointForward.now(), callback)
}

fun showBackwardDatePicker(fragmentManager: FragmentManager, callback: (Long) -> Unit) {
    showDatePicker(fragmentManager, DateValidatorPointBackward.now(), callback)
}

fun showDatePicker(
    fragmentManager: FragmentManager,
    validator: CalendarConstraints.DateValidator,
    callback: (Long) -> Unit
) {
    val constraintsBuilder = CalendarConstraints.Builder().setValidator(validator)

    val picker = MaterialDatePicker.Builder.datePicker().apply {
        setTitleText("Select Date")
        setCalendarConstraints(constraintsBuilder.build())
    }.build()

    picker.addOnPositiveButtonClickListener {
        callback(it)
    }

    picker.show(fragmentManager, "DatePicker")
}