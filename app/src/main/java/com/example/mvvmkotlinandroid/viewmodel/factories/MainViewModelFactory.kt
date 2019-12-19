package com.example.mvvmkotlinandroid.viewmodel.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmkotlinandroid.viewmodel.MainViewModel
import java.lang.Exception

class MainViewModelFactory(val mContext: Context) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(mContext) as T
        }
        throw Exception("View model not fouund for it")
    }

}
