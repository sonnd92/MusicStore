package vn.musicstore.app.utility.validation.validator

abstract class Validator(private var errorMessage:String) {
    abstract fun isValid(content: CharSequence): Boolean
    fun getMessage(): String = errorMessage
}