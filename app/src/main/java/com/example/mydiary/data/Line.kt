package com.example.mydiary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "diary_entry")
data class Line(
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name ="line_no")
    val line_no:Int
    ,
    @ColumnInfo(name = "content")
    val line_text:String
)