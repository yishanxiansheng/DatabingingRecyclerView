package com.tme.lcore.databindinglistview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.tme.lcore.databindinglistview.databinding.ActivityMainItemBinding


/**
 * @author fanshe
 * @date 2021/7/31
 */
class SecondAdapter(private val names: ArrayList<RcyViewModel>, private val context: Context) :
    RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ActivityMainItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.activity_main_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = names.get(position)
        holder.getBinding().user = name
        holder.getBinding().executePendingBindings()
    }

    override fun getItemCount(): Int {
        return names.size
    }

    var i = 0;
    fun changeData(){
        i++
        //如果老的数据发生变化，就出触发更新，新加入的数据也会显示出来
        names.get(1).name.set("heaotian${i}")

        //如果只是新增数据，就必须调用下面方法才会进行更新
        val rcyViewModel = RcyViewModel()
        rcyViewModel.name.set("heshufan")
        rcyViewModel.age.set("3")
        names.add(rcyViewModel)
//        notifyDataSetChanged()
    }

    /**
     * 以前这里是用来获取子组件的，但是现在不需要了，因为binding已经绑定了组件
     */
    class ViewHolder(binding: ActivityMainItemBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {
        private val binding: ActivityMainItemBinding

        fun getBinding(): ActivityMainItemBinding {
            return binding
        }

        init {
            this.binding = binding
        }
    }
}