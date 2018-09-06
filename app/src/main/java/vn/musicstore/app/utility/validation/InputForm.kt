package vn.musicstore.app.utility.validation

import android.content.Context
import android.os.Handler
import android.support.annotation.IdRes
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ScrollView
import vn.musicstore.app.R
import vn.musicstore.app.extensions.getRelativeTop

class InputForm(private val ctx: Context) {
    private var fields: MutableList<Field> = mutableListOf()

    @IdRes
    var wrapperId: Int = 0

    fun addField(field: Field) = fields.add(field)

    fun isValid(): Boolean {
        return try {
            fields.forEach {
                it.isValid()
                clearError(it.getObserveEditText())
            }
            true
        } catch (e: FieldValidateException) {
            showMessage(e.getObserveEditText(), e.getErrorMessage())
            false
        }
    }

    protected fun showMessage(observeEdt: EditText, errorMessage: String) {
        val rootView: View = observeEdt.rootView.findViewById(wrapperId)
        if (rootView is ScrollView) {
            rootView
                    .smoothScrollTo(0, observeEdt.getRelativeTop() - observeEdt.height - ctx.getResources().getDimensionPixelOffset(R.dimen.input_common_height))
        }

        observeEdt.requestFocus()
        observeEdt.error = errorMessage
    }

    protected fun clearError(observeEdt: EditText) {
        observeEdt.error = null
    }

}