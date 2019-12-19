package com.example.mvvmkotlinandroid.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(val mContext: Context) : ViewModel(){

    val dbClicked = MutableLiveData<Boolean>()
    val networkClicked = MutableLiveData<Boolean>()

    fun dbClicked(){
        dbClicked.value = true
    }

    fun networkClicked(){
        networkClicked.value = true;
    }

}
