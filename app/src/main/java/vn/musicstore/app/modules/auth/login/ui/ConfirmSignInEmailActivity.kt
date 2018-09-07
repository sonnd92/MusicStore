package vn.musicstore.app.modules.auth.login.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import vn.musicstore.app.R
import kotlinx.android.synthetic.main.activity_confirm_sign_in_email.*

class ConfirmSignInEmailActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sign_in_email)
        initView()
    }

    private fun initView() {
        v_btn_open_email_app.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            v_btn_open_email_app -> {
                val emailIntent = Intent()
                emailIntent.action = Intent.ACTION_MAIN
                emailIntent.addCategory(Intent.CATEGORY_APP_EMAIL)
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                }
            }
        }
    }
}
