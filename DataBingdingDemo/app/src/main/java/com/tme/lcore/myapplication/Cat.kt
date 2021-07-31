package com.tme.lcore.myapplication

import androidx.databinding.ObservableField


/**
 * @author fanshe
 * @date 2021/7/29
 */
class Cat() {
    //单项绑定，数据变化会让UI进行变化
    var name: ObservableField<String> = ObservableField<String>()
}