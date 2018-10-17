package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.R
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.databinding.FragmentMainBinding
import com.mobile.app.aacexample.ui.insert.InsertDialog
import com.mobile.app.aacexample.util.activityViewModelProvider
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding : FragmentMainBinding

    private lateinit var  mainViewModel : MainViewModel

    @Inject
    lateinit var dialog : InsertDialog

    private val mainAdapter by lazy { MainRecyclerAdapter(this@MainFragment) }

    private val dispose : CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        mainViewModel = activityViewModelProvider(viewModelFactory)
        binding = FragmentMainBinding.inflate(inflater,container,false).apply {
            setLifecycleOwner(this@MainFragment)
        }
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
        }
        fab?.clicks()?.subscribe {
            mainAdapter.datas = listOf(Main(1, "1"))
//            dialog.show(fragmentManager,null)
            dialog.apply {  }.show(fragmentManager,null)
        }.let { dispose.add(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
    private fun subscribeUi(){
        mainViewModel.getMains().observe(viewLifecycleOwner, Observer {
            if(it != null) mainAdapter.submitList(it)
        })
    }
    private fun initializeList(list : List<Main>){
        mainAdapter.submitList(list)
    }
}
