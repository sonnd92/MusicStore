package vn.musicstore.app.utility.validation.validator

class IsPhoneNumber(errorMessage:String):Validator(errorMessage) {

    private val isPhoneNumberPattern:String = "^0[0-9]{9-10}"

    override fun isValid(content: CharSequence): Boolean {
        return content.isNullOrEmpty() || content.matches(Regex(isPhoneNumberPattern))
    }
}