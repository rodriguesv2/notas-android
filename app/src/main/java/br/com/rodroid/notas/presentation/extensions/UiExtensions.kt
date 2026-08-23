package br.com.rodroid.notas.presentation.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_LONG
) {
    Toast.makeText(
        this,
        message,
        duration
    ).show()
}

fun Context.toast(
    messageResId: Int,
    duration: Int = Toast.LENGTH_LONG
) {
    Toast.makeText(
        this,
        messageResId,
        duration
    ).show()
}