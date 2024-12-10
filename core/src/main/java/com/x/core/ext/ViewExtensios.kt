package com.x.core.ext

import android.app.DatePickerDialog
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}

fun View.visible() {
    this.isVisible = true
}

fun View.invisible() {
    this.isVisible = false
}

fun View.gone() {
    this.isGone = true
}

fun EditText.doAfterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Не используется
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Не используется
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged(editable?.toString().orEmpty())
        }
    })
}

fun EditText.showBottomSheetOnFocus(
    fragmentManager: FragmentManager,
    createBottomSheet: (OnTextSelectedListener) -> androidx.fragment.app.DialogFragment
) {
    this.setOnFocusChangeListener { _, hasFocus ->
        if (hasFocus) {
            val listener = object : OnTextSelectedListener {
                override fun onTextSelected(from: String, where: String) {
                    this@showBottomSheetOnFocus.setText(where)
                }
            }
            createBottomSheet(listener).show(fragmentManager, "BottomSheetDialog")
        }
    }
}

fun LinearLayout.showDatePicker(
    currentDate: Calendar = Calendar.getInstance(),
    onDateSelected: (String) -> Unit
) {
    this.setOnClickListener {
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            this.context,
            { _, selectedYear, selectedMonth, selectedDay ->
                currentDate.set(selectedYear, selectedMonth, selectedDay)
                val dateFormat = SimpleDateFormat("dd MMM, EEE", Locale("ru"))
                val formattedDate = dateFormat.format(currentDate.time)
                onDateSelected(formattedDate)
            },
            year,
            month,
            day
        )
        datePicker.show()
    }
}


fun calculateFlightTimeLegacy(departure: String, arrival: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale("ru"))

    val departureTime = formatter.parse(departure)
    val arrivalTime = formatter.parse(arrival)

    val diffMillis = arrivalTime.time - departureTime.time

    val hours = TimeUnit.MILLISECONDS.toHours(diffMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis) % 60

    return "$hours ч $minutes м"
}


@RequiresApi(Build.VERSION_CODES.O)
fun formatToTimeOnly(dateTimeString: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
    val dateTime = LocalDateTime.parse(dateTimeString, inputFormatter)
    return dateTime.format(outputFormatter)
}