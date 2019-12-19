package com.example.mvvmkotlinandroid.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmkotlinandroid.R
import com.example.mvvmkotlinandroid.databinding.ActivityMainBinding
import com.example.mvvmkotlinandroid.viewmodel.MainViewModel
import com.example.mvvmkotlinandroid.viewmodel.factories.MainViewModelFactory

//MVVM(done)
//View Model with factory(done)
//Live Data(done)
//Room(done)
//room update database schema(done)
//insert data initially(done)

//work manager

//Recycler view swipe and adapter
//dialog with match parent

//with fragment viewmodel and data binding and dialog
//view model factory with data binding

//retrofit (Retrofit activity)(done)
//data binding(done)
//glide(done)

//dagger(done) once more would be done after getting through deeply

//test cases for kotlin
//test cases for rx java

//diff Util(done)
//paging(done)

//kotlin(done)
//Coroutine(done)
//By only retrofit(done)
//By Co routine
//By Rx(done)
//extenton function
//codein

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
        mainViewModelFactory = MainViewModelFactory(this)
        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)
        activityMainBinding.mainViewModel = mainViewModel;

        mainViewModel.networkClicked.observe(this, Observer {
            startActivity(Intent(this@MainActivity, NetworkActivity::class.java))
        })

        mainViewModel.dbClicked.observe(this, Observer {
            startActivity(Intent(this@MainActivity, DbActivity::class.java))
        })
    }
}
