package com.leomarkpaway.viewbindingrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.leomarkpaway.viewbindingrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mockItem: ArrayList<Item> = ArrayList()
        for (number in 1..10) {
            mockItem.add(Item("Item $number"))
        }

        setupItemList(mockItem)

    }

    private fun setupItemList(items: List<Item>) = with(binding.rvItemList) {
        adapter = ItemAdapter(items)
        layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

}