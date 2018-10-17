package com.mobile.app.aacexample.ui.insert

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.R
import kotlinx.android.synthetic.main.dialog_insert.*

class InsertDialog : DialogFragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_insert,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        positiveBtn?.clicks()?.subscribe {
            dismiss()
        }
        negativeBtn?.clicks()?.subscribe {
            dismiss()
        }
    }
    companion object {
        fun newInstance() : InsertDialog = InsertDialog()
    }
}