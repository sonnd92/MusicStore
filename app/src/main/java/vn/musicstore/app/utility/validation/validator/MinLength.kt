package vn.musicstore.app.utility.validation.validator

class MinLength(private val minLength: Int, errorMsg :String) : Validator(errorMsg) {
    override fun isValid(content: CharSequence): Boolean {
        return content.isNullOrEmpty() || content.length >= minLength
    }
}