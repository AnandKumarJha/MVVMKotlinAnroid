package com.example.mvvmkotlinandroid.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlinandroid.model.StudentRepository
import com.example.mvvmkotlinandroid.model.pojo.Student

class DbViewModel(mApplication: Application) : ViewModel() {

    private var studentRepository: StudentRepository

    init {
        studentRepository = StudentRepository(mApplication)
    }

    suspend fun getAllStudents(): LiveData<List<Student>> {
        return studentRepository.getAllStudent()
    }

    suspend fun insertStudent(student: Student) {
        return studentRepository.insertStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        return studentRepository.deleteStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        return studentRepository.updateStudent(student)
    }

    suspend fun deleteAllStudent(student: Student) {
        return studentRepository.deleteAllStudent(student)
    }
}