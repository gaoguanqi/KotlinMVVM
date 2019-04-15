package com.maple.jetpackdemo.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * author: gaogq
 * time: 2019/4/10 16:44
 * description:
 */
@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao():UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        @Synchronized
        private fun buildDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java,context.packageName+".db")
                        .allowMainThreadQueries() //在主线程中查询，默认子线程
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }
}