package com.mgbachi_ugo.portfolio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreference = SharedPreference(applicationContext)
        text_reg_link.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            val username = edit_login_username.text.toString()
            val pwd = edit_login_pwd.text.toString()
            if (username.trim().isNotEmpty() && pwd.trim().isNotEmpty()) {
                val uName = sharedPreference.getUserName(Constants.KEY_USERNAME)
                val password = sharedPreference.getPwd(Constants.KEY_PWD)
                if (username == uName && pwd == password) {
                    val i = Intent(applicationContext, MainActivity::class.java)
                    startActivity(i)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect details", Toast.LENGTH_SHORT).show()
                    edit_login_username?.text?.clear()
                    edit_login_pwd?.text?.clear()
                }

            } else {
                Toast.makeText(this, "Please put in your details", Toast.LENGTH_SHORT).show()

            }
        }
    }


}
