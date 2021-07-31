package com.tme.lcore.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tme.lcore.myapplication.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.security.AccessController.getContext
import java.util.*
import java.util.EnumSet.of

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        Log.i(TAG, Arrays.toString(Build.SUPPORTED_ABIS))
        Log.i(TAG, Arrays.toString(Build.SUPPORTED_32_BIT_ABIS))
        Log.i(TAG, Build.SUPPORTED_32_BIT_ABIS.size.toString() + " ")
        Log.i(TAG, Arrays.toString(Build.SUPPORTED_64_BIT_ABIS))
        Log.i(TAG, Build.SUPPORTED_64_BIT_ABIS.size.toString() + " ")
        Log.i(TAG, is64Bit().toString())

        Log.i(TAG, isART64().toString())

        Log.i(TAG, System.getProperty("java.library.path"))

        var application =
            this.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128)
        Log.i(TAG, application.nativeLibraryDir)

        var binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        var cat = Cat()
        cat.name.set("Dog")
        binding.cat = cat

        var dataViewModel = DataViewModel()
        dataViewModel.nameLiveData.value = "Tiger"
        binding.viewmodel = dataViewModel
        binding.lifecycleOwner = this

        var num = 1
        binding.text1.setOnClickListener {
            num++
            dataViewModel.nameLiveData.value = "heshufan${num}"
        }


    }

    fun is64Bit(): Boolean {
        var is64bit = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            is64bit = Build.SUPPORTED_64_BIT_ABIS.size > 0
        } else {
            try {
                val localBufferedReader = BufferedReader(FileReader("/proc/cpuinfo"))
                if (localBufferedReader.readLine().contains("aarch64")) {
                    is64bit = true;
                }
                localBufferedReader.close();
            } catch (exception: IOException) {
                exception.printStackTrace();
            }
        }
        return is64bit
    }

    fun isART64(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return android.os.Process.is64Bit()
        }
        return false
    }


}