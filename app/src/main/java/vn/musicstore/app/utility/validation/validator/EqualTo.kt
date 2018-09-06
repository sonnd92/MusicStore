package vn.musicstore.app.utility.validation.validator

import android.widget.EditText

class EqualTo(private val comparisionEdt: EditText, errorMsg:String) : Validator(errorMsg) {
    override fun isValid(content: CharSequence): Boolean {
        return (content.isNullOrEmpty() && comparisionEdt.text.isNullOrEmpty()) || content == comparisionEdt.text
    }
}