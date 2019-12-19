package com.example.mvvmkotlinandroid.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.mvvmkotlinandroid.model.dao.StudentDao
import com.example.mvvmkotlinandroid.model.db.StudentDatabase
import com.example.mvvmkotlinandroid.model.pojo.Student

class StudentRepository(application: Application) {

    var dao: StudentDao = StudentDatabase.getStudentDatabase(application).getStudentDao()

    suspend fun insertStudent(student: Student) {
        dao.insertStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        dao.deleteStudent(student)
    }

    suspend fun deleteAllStudent(student: Student) {
        dao.deleteAllStudents(student)
    }

    suspend fun updateStudent(student: Student) {
        dao.updateStudent(student)
    }

    suspend fun getAllStudent() : LiveData<List<Student>> {
       return dao.getAllStudents()
    }
}