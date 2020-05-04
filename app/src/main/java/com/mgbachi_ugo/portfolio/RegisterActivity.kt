package com.mgbachi_ugo.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        sharedPreference = SharedPreference(applicationContext)
        btn_reg.setOnClickListener {
            val name = edit_reg_name.text.toString()
            val uName = edit_reg_slack_username.text.toString()
            val email = edit_reg_email.text.toString()
            val pwd = edit_reg_pwd.text.toString()
            if (name.isEmpty() || uName.isEmpty() || email.isEmpty() || pwd.isEmpty() ) {

                Toast.makeText(this, "registration not successful please answer all questions", Toast.LENGTH_SHORT).show()
                clearTextInput()
            } else if (sharedPreference.getName(Constants.KEY_NAME) == name || sharedPreference.getEmail(Constants.KEY_EMAIL) == email) {
                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show()
                clearTextInput()
            } else {
                sharedPreference.putName(Constants.KEY_NAME, name)
                sharedPreference.putUserName(Constants.KEY_USERNAME, uName)
                sharedPreference.putEmail(Constants.KEY_EMAIL, email)
                sharedPreference.putPwd(Constants.KEY_PWD, pwd)
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                finish()

            }

        }


    }

    private fun clearTextInput() {
        edit_reg_email?.text?.clear()
        edit_reg_name?.text?.clear()
        edit_reg_pwd?.text?.clear()
        edit_reg_slack_username?.text?.clear()
    }
}
