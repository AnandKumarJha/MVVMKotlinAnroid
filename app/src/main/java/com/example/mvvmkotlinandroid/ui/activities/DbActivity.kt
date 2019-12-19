package com.example.mvvmkotlinandroid.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmkotlinandroid.R
import com.example.mvvmkotlinandroid.databinding.ActivityDbBinding
import com.example.mvvmkotlinandroid.model.pojo.Student
import com.example.mvvmkotlinandroid.viewmodel.DbViewModel
import com.example.mvvmkotlinandroid.viewmodel.factories.DbViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DbActivity : AppCompatActivity() {

    private lateinit var dbViewModelFactory: DbViewModelFactory
    private lateinit var dbViewModel: DbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBindingMain: ActivityDbBinding = DataBindingUtil.setContentView(this, R.layout.activity_db)
        dbViewModelFactory = DbViewModelFactory(application)
        dbViewModel = ViewModelProviders.of(this, dbViewModelFactory).get(DbViewModel::class.java)

//        activityBindingMain

        GlobalScope.launch {
            dbViewModel.
                insertStudent(Student(0, "anand", "2013026156"))

            withContext(Dispatchers.Main){
            dbViewModel.getAllStudents().observe(this@DbActivity, Observer {
                Log.e("TAG", ""+it)
            })
            }

        }

    }
}
