package com.agohra.democircleci.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agohra.democircleci.data.db.entities.CURRENT_TOKEN
import com.agohra.democircleci.data.db.entities.User

@Dao
interface UserDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun user(user:User) : Long

    @Query("Select * FROM user WHERE userID = $CURRENT_TOKEN")
    fun getUser() : LiveData<User>
}