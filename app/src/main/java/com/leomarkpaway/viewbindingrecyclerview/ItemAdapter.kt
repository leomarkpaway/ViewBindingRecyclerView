package com.leomarkpaway.viewbindingrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.leomarkpaway.viewbindingrecyclerview.databinding.ItemBinding

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    inner class ItemHolder(private val binding: ItemBinding) :  RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) = with(binding) {
            tvTitle.text = item.itemName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemHolder {
        val binding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item,
            parent,
            false
        )
        return ItemHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemAdapter.ItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

}