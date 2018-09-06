package vn.musicstore.app.utility.validation.validator

import kotlinx.android.synthetic.*
import vn.musicstore.app.R

class IsRequired(errorMessage:String) : Validator(errorMessage) {
    override fun isValid(content: CharSequence): Boolean {
        return !content.isNullOrEmpty()
    }
}