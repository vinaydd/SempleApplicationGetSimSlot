package com.example.sharadsingh.sempleapplication.utills

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by root on 2/10/15.
 */
class AppPreference(context: Context) {
    private val appSharedPrefs: SharedPreferences
    private val prefsEditor: SharedPreferences.Editor

    init {
        this.appSharedPrefs = context.getSharedPreferences(Constants.APP_SHARED_PREFS, Activity.MODE_PRIVATE)
        this.prefsEditor = appSharedPrefs.edit()
    }

    fun getStringValueForTag(tagName: String): String {
        return appSharedPrefs.getString(tagName, "")

    }

    fun setStringValueForTag(tagName: String, value: String) {
        prefsEditor.putString(tagName, value)
        prefsEditor.commit()
    }

    fun setIntValueForTag(tagName: String, value: Int) {
        prefsEditor.putInt(tagName, value)
        prefsEditor.commit()
    }

    fun getIntValueForTag(tagName: String): Int {
        return appSharedPrefs.getInt(tagName, 0)
    }

    fun setBooleanValueForTag(tagName: String, value: Boolean) {
        prefsEditor.putBoolean(tagName, value)
        prefsEditor.commit()
    }

    fun getBooleanValueForTag(tagName: String): Boolean {
        return appSharedPrefs.getBoolean(tagName, false)
    }


    fun clearPreferences() {
        prefsEditor.clear()
        prefsEditor.commit()
    }


}