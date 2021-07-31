package com.tme.lcore.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.PropertyChangeRegistry
import java.util.*


/**
 * @author fanshe
 * @date 2021/7/29
 */
class DataViewModel :ViewModel() {
    var nameLiveData = MutableLiveData<String>()
}

class DataViewModelObservable : DataViewObservable(){
    var name = ObservableField("Fish")
}

/**
 * open 允许被继承
 */
open class DataViewObservable : ViewModel() , Observable {

    var callbacks = PropertyChangeRegistry()
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
        callbacks.remove(callback)
    }

    /**
     * 通知数据发生变化，数据需要用Bindable注解
     */
    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }
}

