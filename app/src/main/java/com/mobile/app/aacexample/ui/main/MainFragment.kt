package com.mobile.app.aacexample.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.databinding.FragmentMainBinding
import com.mobile.app.aacexample.ui.insert.InsertDialog
import com.mobile.app.aacexample.util.InjectorUtils
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    private lateinit var  mainViewModel : MainViewModel

    private val mainAdapter by lazy { MainRecyclerAdapter(mainViewModel) }

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

        show?.clicks()?.subscribe {
            fab.animate().translationY(50f).setDuration(1000).start()
        }.let { dispose.add(it) }
        hide?.clicks()?.subscribe {
            fab.animate().translationY(0f).setDuration(1000).start()
        }.let { dispose.add(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
    private fun subscribeUi(){
        mainViewModel.mainList.observe(viewLifecycleOwner, Observer {
            Log.i("hsik","mainList = $it")
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
