package com.maple.jetpackdemo.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * author: gaogq
 * time: 2019/4/10 16:26
 * description:
 */
@Entity(tableName = "users")
class User {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    @ColumnInfo(name = "name")
    lateinit var name:String
}