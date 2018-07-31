package com.example.sharadsingh.sempleapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sharadsingh.sempleapplication.utills.AppPreference

   open class BaseActivity :AppCompatActivity(),Getvalues{
       override fun getName(): String {
           return "vinay"
       }
       override fun getAddress(): String {
           return "B 212 New Ashok Nagar New Delhi 110096"
       }
       override fun getContactNumber(): String {
         return "7836914331"
       }
       private var prefs : AppPreference? = null;
        private var isErrorResponse : Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = AppPreference(applicationContext)
        isErrorResponse = false

    }


   open fun <T> processResponse(result: T?) {
        isErrorResponse = false
        if (result == null) {
            isErrorResponse = true
            return
        }

    }

}