package com.example.sharadsingh.sempleapplication

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

class Myapplication: MultiDexApplication(){
    val TAG = Myapplication::class.java!!.getSimpleName()
    var mContext: Context? = null
    private var mInstance: Myapplication? = null

    @Synchronized
    fun getInstance(): Myapplication? {
        return mInstance
    }

    fun getContext(): Context? {
        return mContext
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mContext = this

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}