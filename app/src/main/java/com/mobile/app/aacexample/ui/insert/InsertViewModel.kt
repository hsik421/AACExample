package com.mobile.app.aacexample.ui.insert

import android.arch.lifecycle.ViewModel
import android.util.Log

class InsertViewModel : ViewModel(), DialogListener {

    override fun onPositive() {
        Log.i("hsik","onPositive")
    }

    override fun onNegative() {
        Log.i("hsik","onPositive")
    }
}
interface DialogListener{
    fun onPositive()
    fun onNegative()
}