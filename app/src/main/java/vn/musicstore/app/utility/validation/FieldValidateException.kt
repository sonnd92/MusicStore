package vn.musicstore.app.utility.validation

import android.widget.EditText

class FieldValidateException(private var errorMessage: String, private var observeEditText: EditText) : Exception(errorMessage) {
    fun getErrorMessage() = errorMessage
    fun getObserveEditText() = observeEditText
}