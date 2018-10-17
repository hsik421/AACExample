package com.mobile.app.aacexample.util

import android.content.Context
import android.net.ConnectivityManager

open class NetworkUril internal constructor(val context : Context){
    open fun hasNetworkConnection() : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}