/*package com.example.mydiary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LineDao {
    @Insert()
    suspend fun addLine(line:Line){
    }
    @Query(value="SELECT * FROM saved_files order by line_no ASC")
    fun readAllData():LiveData<List<Line>>


}*/