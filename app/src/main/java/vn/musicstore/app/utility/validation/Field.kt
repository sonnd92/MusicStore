package vn.musicstore.app.utility.validation

import android.widget.EditText
import vn.musicstore.app.extensions.isRealVisible
import vn.musicstore.app.utility.validation.validator.Validator
import java.util.*

class Field(private val observeEdt: EditText) {
    var validators: MutableList<Validator> = LinkedList()

    fun getObserveEditText() = observeEdt

    fun isValid() {
        validators.forEach {
            if (observeEdt.isRealVisible() && !it.isValid(observeEdt.text)) {
                throw FieldValidateException(it.getMessage(), observeEdt)
            }
        }
    }

    class Builder(private val builderEditText: EditText)
    {
        private var builderValidators: MutableList<Validator> = LinkedList()
        fun validate(validator: Validator) : Field.Builder {
            builderValidators.add(validator)
            return this
        }

        fun build():Field{
            val field = Field(builderEditText)
            field.validators = builderValidators
            return field
        }
    }
}