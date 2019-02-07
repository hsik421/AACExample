package com.mobile.app.aacexample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.MyApplication
import com.mobile.app.aacexample.databinding.FragmentMainBinding
import com.mobile.app.aacexample.ui.insert.InsertDialog
import com.mobile.app.aacexample.util.InjectorUtils
import com.mobile.app.aacexample.util.activityViewModelProvider
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment @Inject constructor(): DaggerFragment() {

    private lateinit var binding : FragmentMainBinding

    private lateinit var  mainViewModel : MainViewModel

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainAdapter by lazy { MainRecyclerAdapter(mainViewModel) }

    private val dispose : CompositeDisposable = CompositeDisposable()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = FragmentMainBinding.inflate(inflater,container,false).apply { setLifecycleOwner(this@MainFragment) }

        mainViewModel = activityViewModelProvider(viewModelFactory)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUi()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recycler?.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.VERTICAL))
        }
        fab?.clicks()?.subscribe {
            InsertDialog.newInstance().apply {
                dialogListener = object : InsertDialog.DialogListener{
                    override fun onPositive(text: String) {
                        mainViewModel.insert(text)
                    }
                }
            }.show(fragmentManager,null)

        }.let { dispose.add(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
    private fun subscribeUi(){
        mainViewModel.test.observe(viewLifecycleOwner, Observer {
            Log.i("hsik","it = $it")
            binding.hasMains = (it != null && it.isNotEmpty())
            if(it != null && it.isNotEmpty()){
                mainAdapter.submitList(it)
            }
        })
        mainViewModel.snackbarMessage.observe(viewLifecycleOwner, Observer {
            Log.i("hsik","snackbarMessage = $it")
            Snackbar.make(coordinator?:return@Observer,it,Snackbar.LENGTH_SHORT).show()
        })
    }
}
