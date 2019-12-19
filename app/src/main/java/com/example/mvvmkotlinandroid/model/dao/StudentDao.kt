package com.example.mvvmkotlinandroid.model.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.mvvmkotlinandroid.model.pojo.Student

@Dao
interface StudentDao {

    @Query("Select * from Student")
    fun getAllStudents(): LiveData<List<Student>>

    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(students: Student)

    @Delete
    fun deleteAllStudents(vararg students: Student)

    @Update
    fun updateStudent(student: Student)
}