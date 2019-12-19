package com.example.mvvmkotlinandroid.model.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmkotlinandroid.model.dao.StudentDao
import com.example.mvvmkotlinandroid.model.pojo.Student
import java.util.*

@Database(entities = arrayOf(Student::class), version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getStudentDatabase(application: Application): StudentDatabase {
            var instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this){
                instance =
                    Room.databaseBuilder(application.applicationContext, StudentDatabase::class.java, "Student_database").addCallback(callback).addMigrations(
                        MIGRATION_1_2, MIGRATION_2_3).build()
                INSTANCE = instance
                return instance as StudentDatabase
            }

        }

        val callback = object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //called only once when database created
                INSTANCE?.getStudentDao()!!.insertStudent(Student(0, "anand 1", "1111"))
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                //colled everytime when database opened(database used for read/write after killing and reopening app)
                super.onOpen(db)
                INSTANCE?.getStudentDao()!!.insertStudent(Student(0, "anand 555", "1111"))
            }
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Student " + "ADD COLUMN Address TEXT not null default ''")
            }
        }

        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Student " + "ADD COLUMN Sex TEXT not null default ''")
            }
        }
    }


}