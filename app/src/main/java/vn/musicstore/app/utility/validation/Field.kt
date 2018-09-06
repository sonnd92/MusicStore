package vn.musicstore.app.utility.validation

import android.widget.EditText
import vn.musicstore.app.extensions.isRealVisible
import vn.musicstore.app.utility.validation.validator.Validator
import java.util.*

class Field(private val observeEdt: EditText) {
    private var validators: MutableList<Validator> = LinkedList()

    companion object {
        fun using(editText: EditText) = Field(editText).let {

        }
    }

    fun getObserveEditText() = observeEdt

    fun validate(validator: Validator) = validators.add(validator)

    fun isValid() {
        validators.forEach {
            if (observeEdt.isRealVisible() && !it.isValid(observeEdt.text)) {
                throw FieldValidateException(it.getMessage(), observeEdt)
            }
        }
    }
}