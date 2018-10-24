package com.mobile.app.aacexample.ui.insert

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.dialog_insert.*

class InsertDialog : DialogFragment(){

    private val disposable = CompositeDisposable()

    lateinit var dialogListener: DialogListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_insert,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        positiveBtn?.clicks()?.subscribe {
            dialogListener.onPositive(edit?.text.toString())
            dismiss()
        }.let { disposable.add(it) }
        negativeBtn?.clicks()?.subscribe {
            dismiss()
        }.let { disposable.add(it) }
    }
    companion object {
        fun newInstance() : InsertDialog = InsertDialog()
    }
    interface DialogListener{
        fun onPositive(text : String)
    }
}