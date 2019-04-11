package com.maple.jetpackdemo.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * author: gaogq
 * time: 2019/4/10 16:26
 * description:
 */
@Entity(tableName = "table_user")
class User {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "name")
    lateinit var name:String
}