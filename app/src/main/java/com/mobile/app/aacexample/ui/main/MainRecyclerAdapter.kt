package com.mobile.app.aacexample.ui.main

import android.arch.lifecycle.LifecycleOwner
import android.support.v7.recyclerview.extensions.AsyncListDiffer
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.app.aacexample.R
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.databinding.ItemMainBinding

class MainRecyclerAdapter(private val lifecycleOwner: LifecycleOwner,
                          private val mainViewModel : MainViewModel) : ListAdapter<Any, MainRecyclerAdapter.MainViewHolder>(Diff){

    private val differ = AsyncListDiffer<Any>(this, Diff)
    var datas : List<Main> = emptyList()
        set(value) {
            Log.i("hsik","value = $value")
            field = value
            differ.submitList(buildMergedList(value))
        }

    companion object {
        val Diff = object : DiffUtil.ItemCallback<Any>(){
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean{
                Log.i("hsik","oldItem = $oldItem")
                Log.i("hsik","newItem = $newItem")
                return when{
                    oldItem is Main && newItem is Main -> oldItem.idx == newItem.idx
                    else-> false
                }
            }

            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when{
                oldItem is Main && newItem is Main -> oldItem == newItem
                else -> true
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            R.layout.item_main -> MainViewHolder.ContentViewHolder(ItemMainBinding.inflate(inflater,parent,false))
            else-> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, p1: Int) {
        when(holder){
            is MainViewHolder.ContentViewHolder -> holder.binding.apply {
                setLifecycleOwner(lifecycleOwner)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int): Int =
            when(differ.currentList[position]){
                is Main -> R.layout.item_main
                else -> throw IllegalStateException("differ.currentList[position] = ${differ.currentList[position]}")
            }
    private fun buildMergedList(datas : List<Main> = this.datas) : List<Any>{
        val merged = mutableListOf<Any>()
        if(datas.isNotEmpty()){
            merged.addAll(datas)
        }
        return merged
    }




    sealed class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        class ContentViewHolder(val binding : ItemMainBinding) : MainViewHolder(binding.root)
    }
}