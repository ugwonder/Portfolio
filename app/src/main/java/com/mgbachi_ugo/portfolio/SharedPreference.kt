package com.mgbachi_ugo.portfolio

import android.content.Context
import java.security.AccessControlContext

class SharedPreference(val  context: Context) {
    private val PREFS_NAME ="userdata"

     private val sharedPreference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun putName(KEY_NAME: String, value: String){
        sharedPreference.edit().putString(KEY_NAME, value).apply()
    }

    fun getName(KEY_NAME: String): String? {
        return sharedPreference.getString(KEY_NAME, null)
    }
    fun putUserName(KEY_NAME: String, value: String) {
        sharedPreference.edit().putString(KEY_NAME, value).apply()
    }
    fun getUserName(KEY_NAME: String): String? {
        return sharedPreference.getString(KEY_NAME, null)
    }
    fun putEmail(KEY_NAME: String, value: String) {
        sharedPreference.edit().putString(KEY_NAME, value).apply()
    }
    fun  getEmail(KEY_NAME: String): String? {
        return sharedPreference.getString(KEY_NAME, null)
    }
    fun putPwd(KEY_NAME: String, value: String){
        sharedPreference.edit().putString(KEY_NAME, value).apply()
    }
    fun getPwd(KEY_NAME: String):String? {
        return sharedPreference.getString(KEY_NAME, null)
    }
}