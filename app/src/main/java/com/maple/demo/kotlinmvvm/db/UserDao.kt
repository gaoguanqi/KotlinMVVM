package com.maple.jetpackdemo.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update



/**
 * author: gaogq
 * time: 2019/4/10 16:30
 * description:
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM table_user")
    val all: List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:User)

    @Query("SELECT * FROM table_user WHERE uid = :id")
    fun getUserById(id:Int):User

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user:User)

}