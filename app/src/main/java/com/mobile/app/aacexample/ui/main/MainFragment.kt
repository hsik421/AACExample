package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.databinding.FragmentMainBinding
import com.mobile.app.aacexample.ui.insert.InsertDialog
import com.mobile.app.aacexample.util.InjectorUtils
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    private lateinit var  mainViewModel : MainViewModel

    private val mainAdapter by lazy { MainRecyclerAdapter(mainViewModel,this@MainFragment) }

    private val dispose : CompositeDisposable = CompositeDisposable()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = FragmentMainBinding.inflate(inflater,container,false).apply { setLifecycleOwner(this@MainFragment) }

        mainViewModel = ViewModelProviders.of(this,InjectorUtils.provideMainViewModelFactory(requireContext())).get(MainViewModel::class.java)

        subscribeUi()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recycler?.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context)
        }
        fab?.clicks()?.subscribe {
//            mainAdapter.datas = listOf(Main(1, "1"))
//            dialog.show(fragmentManager,null)
            InsertDialog.newInstance().apply {  }.show(fragmentManager,null)
        }.let { dispose.add(it) }

    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
    private fun subscribeUi(){
        mainViewModel.mainList.observe(viewLifecycleOwner, Observer {
            binding.hasMains = (it != null && it.isNotEmpty())
            if(it != null && it.isNotEmpty()){
                mainAdapter.submitList(it)
            }
        })
    }
    companion object {
        fun newInstance() : MainFragment = MainFragment()
    }
}
