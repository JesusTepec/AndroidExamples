package com.example.apptest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apptest.util.KEY_EMAIL
import com.example.apptest.util.KEY_TOKEN
import com.pixplicity.easyprefs.library.Prefs

open class BaseViewModel() : ViewModel() {

    var sessionEmail: String
        set(value) {
            Prefs.putString(KEY_EMAIL, value)
        }
        get() = Prefs.getString(KEY_EMAIL, "")

    var sessionToken: String
        set(value) {
            Prefs.putString(KEY_TOKEN, value)
        }
        get() = Prefs.getString(KEY_TOKEN, "")


}