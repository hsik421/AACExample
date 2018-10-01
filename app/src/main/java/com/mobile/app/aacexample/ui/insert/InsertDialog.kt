package com.mobile.app.aacexample.ui.insert

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.R
import com.mobile.app.aacexample.util.viewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.dialog_insert.*
import javax.inject.Inject

class InsertDialog @Inject constructor() : DialogFragment() , HasSupportFragmentInjector{

    @Inject
    lateinit var fragmentInjector : DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private lateinit var InsertViewModel : InsertViewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        InsertViewModel = viewModelProvider(viewModelFactory)
        return inflater.inflate(R.layout.dialog_insert,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        positiveBtn?.clicks()?.subscribe {
            InsertViewModel.onPositive()
            dismiss()
        }
        negativeBtn?.clicks()?.subscribe {
            InsertViewModel.onNegative()
            dismiss()
        }
    }
    companion object {
        fun newInstance() : InsertDialog = InsertDialog()
    }
}