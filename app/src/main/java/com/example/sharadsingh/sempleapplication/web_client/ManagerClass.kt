package com.example.sharadsingh.sempleapplication.web_client

import android.content.Context

import com.example.sharadsingh.sempleapplication.response.Baseresponce
import com.example.sharadsingh.sempleapplication.utills.Constants


import org.json.JSONObject

/**
 * Created by root on 10/11/16.
 */
class ManagerClass protected constructor() {


    fun getLogin(context: Context, requstType: String, Mode: String, obj: JSONObject, isProgress: Boolean) {
        val httptask = CommonWebCallManagerClassHandller(context, Constants.HOST_URL, Baseresponce::class.java, Constants.LOGIN_URL, requstType, Mode, obj)
        httptask.setIsApiKeyRequired(true)
        httptask.setForFragment(false)
        httptask.setShowProgress(isProgress)
    }

    companion object {
        private var singleInstance: ManagerClass? = null
        val instance: ManagerClass
            get() {
                if (singleInstance == null) {
                    singleInstance = ManagerClass()
                }
                return singleInstance!!
            }
    }

}
