package com.tme.lcore.databindinglistview

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @author fanshe
 * @date 2021/7/31
 */
class RcyViewModel :ViewModel(){
    var name: MutableLiveData<String> = MutableLiveData<String>()
    var age: MutableLiveData<String> = MutableLiveData<String>()
}