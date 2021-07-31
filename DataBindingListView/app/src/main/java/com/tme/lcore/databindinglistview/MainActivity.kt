package com.tme.lcore.databindinglistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var names: ArrayList<RcyViewModel> = ArrayList()
    var adapter: SecondAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        for (i in 1..5) {
            val rcyViewModel = RcyViewModel()
            rcyViewModel.name.set("heshufan${i}")
            rcyViewModel.age.set("${i}")
            names.add(rcyViewModel)
        }
        adapter = SecondAdapter(names = names, context = this)
        recyclerView.adapter = adapter
    }

    fun addData(view: View) {
        adapter!!.changeData()
    }
}