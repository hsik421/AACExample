package com.mobile.app.aacexample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.clicks
import com.mobile.app.aacexample.data.local.Main
import com.mobile.app.aacexample.databinding.ItemMainBinding

class MainRecyclerAdapter(private val mainViewModel : MainViewModel) : ListAdapter<Main, MainRecyclerAdapter.MainViewHolder.ContentViewHolder>(Diff){

    companion object {
        val Diff = object : DiffUtil.ItemCallback<Main>(){
            override fun areItemsTheSame(oldItem: Main, newItem: Main): Boolean{
                return oldItem.idx == newItem.idx
            }

            override fun areContentsTheSame(oldItem: Main, newItem: Main): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder.ContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder.ContentViewHolder(ItemMainBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder.ContentViewHolder, pos: Int) {
        holder.binding.apply {
            root.clicks().subscribe {
                mainViewModel.onDeleteClick(pos)
            }
            main = getItem(pos)
            executePendingBindings()
        }
    }

    sealed class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        class ContentViewHolder(val binding : ItemMainBinding) : MainViewHolder(binding.root)
    }
}