package vn.musicstore.app.utility.validation.validator

class IsEmail(errorMessage:String) : Validator(errorMessage) {

    private val checkEmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    override fun isValid(content: CharSequence) = content.matches(Regex(checkEmailPattern))
}