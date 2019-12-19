package com.example.mvvmkotlinandroid.model.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "roll_num") val rollNo: Int,

    @ColumnInfo(name = "name", defaultValue = "")
    val name: String,

    @ColumnInfo(name = "phoneNumber", defaultValue = "N/a")
    val phoneNumber: String
)