package com.example.mvvmkotlinandroid.viewmodel.factories

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmkotlinandroid.viewmodel.DbViewModel
import java.lang.Exception

class DbViewModelFactory(val mApplication : Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DbViewModel::class.java)){
            return DbViewModel(mApplication) as T
        }
        throw Exception("The given view model is not found");
    }

}