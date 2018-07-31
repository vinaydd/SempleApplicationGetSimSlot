package com.example.sharadsingh.sempleapplication.web_client

import android.app.ProgressDialog
import android.content.Context
import android.util.Log

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.sharadsingh.sempleapplication.activity.BaseActivity
import com.example.sharadsingh.sempleapplication.utills.AppPreference
import com.example.sharadsingh.sempleapplication.utills.Constants
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper


import org.json.JSONObject

import java.io.IOException


/**
 * Created by root on 10/11/16.
 */
class CommonWebCallManagerClassHandller<T>(internal var _context: Context, internal var _requestUrl: String, internal var _responseType: Class<T>, internal var methodName: String, private val request_type: String, private val mode: String, internal var `object`: JSONObject?) : BaseActivity() {
    protected var _dialog: ProgressDialog? = null
    protected var message = "Loading..."
    private var isForFragment: Boolean = false
    private var isApiRequired = true
    private var isToShowProgress = true
    private val apiKey: String
    internal var mMODE: Int = 0
    internal var url: String
    internal var result: T? = null
    internal var response = ""
    internal var mapper: ObjectMapper

    init {
        AndroidNetworking.initialize(_context.applicationContext)
        url = _requestUrl + this.methodName
        val prefs = AppPreference(_context.applicationContext)
        apiKey = prefs.getStringValueForTag(Constants.API_KEY)
        mapper = ObjectMapper()
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        CommonAndroidNetworkWithJactionParserFunction(request_type)
    }

    private fun CommonAndroidNetworkWithJactionParserFunction(request_type: String) {
        if (request_type.equals("object", ignoreCase = true)) {
            if (isToShowProgress) {
                _dialog = ProgressDialog.show(_context, "", message, true)
            }
            if (`object` == null) {
                callWithGetWithPAramiter(url)
            } else {
                callWithJsonBodyWithPost(url, `object`!!)

            }
        } else {
            if (isToShowProgress) {
                _dialog = ProgressDialog.show(_context, "", message, true)
            }
        }
    }

    private fun callWithJsonBodyWithPost(url: String, `object`: JSONObject) {
        Log.d("url", url)
        AndroidNetworking.post(url)
                .addJSONObjectBody(`object`)
                .addHeaders("authKey", "27d6POA4EuUPneahXGMhwGWyHK48kAta6somSHOH+e2yX4HGuPEWFU6VSzVquIPx")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        Log.d("Responce_data", response.toString())
                        if (_dialog != null) {
                            _dialog!!.cancel()
                        }
                        try {
                            result = mapper.readValue(response.toString(), _responseType)
                            (_context as BaseActivity).processResponse<Any>(result)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }

                    override fun onError(error: ANError) {
                        if (_dialog != null) {
                            _dialog!!.cancel()
                        }
                        val response = error.message
                    }
                })
    }

    private fun callWithGetWithPAramiter(url: String) {
        AndroidNetworking.get(url)
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .addHeaders("token", "1234")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        Log.d("Responce_data", response.toString())
                        if (_dialog != null) {
                            _dialog!!.cancel()
                        }
                        try {
                            result = mapper.readValue(response.toString(), _responseType)
                            (_context as BaseActivity).processResponse<Any>(result)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                        // do anything with response
                    }

                    override fun onError(error: ANError) {
                        if (_dialog != null) {
                            _dialog!!.cancel()
                        }
                        val response = error.message
                    }
                })
    }

    fun setIsApiKeyRequired(isReqoured: Boolean) {
        this.isApiRequired = isReqoured
    }

    fun setForFragment(isFragment: Boolean) {
        this.isForFragment = isFragment
    }


    fun setShowProgress(isToShowProgress: Boolean) {
        this.isToShowProgress = isToShowProgress
    }



}
