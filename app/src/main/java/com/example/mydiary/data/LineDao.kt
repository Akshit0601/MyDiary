package com.example.mydiary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLine(line:Line){
    }
    @Query(value="SELECT * FROM diary_entry order by line_no ASC")
    fun readAllData():LiveData<List<Line>>


}