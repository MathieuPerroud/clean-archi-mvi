package com.bookandgo.common.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.google.android.material.snackbar.Snackbar

fun View.popSnackbar(message: String, duration: Int) {
    Snackbar.make(this,
        message, duration
    ).show()

}

fun View.popSnackbarWithAction(message: String, duration: Int, actionName: String, action: () -> Unit ) {
    Snackbar.make(
        this,
        message, duration
    ).apply {
        setAction(actionName) { action.invoke() }
        show()
    }
}