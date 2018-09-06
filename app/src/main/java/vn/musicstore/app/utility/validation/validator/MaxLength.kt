package vn.musicstore.app.utility.validation.validator

class MaxLength(private val maxLength:Int, errorMsg:String) : Validator(errorMsg) {
    override fun isValid(content: CharSequence): Boolean = content.isNullOrEmpty() || content.length <= maxLength
}