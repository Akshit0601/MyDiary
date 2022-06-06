package com.example.mydiary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Line::class], version = 1, exportSchema = false)
abstract class LineDatabase:RoomDatabase() {

    abstract fun lineDao():LineDao


    companion object{
        @Volatile
        private var INSTANCE: LineDatabase? = null
        fun getDatabase(context: Context): LineDatabase? {
            val tempInstance= INSTANCE
            if(tempInstance!= INSTANCE){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    LineDatabase::class.java,
                    "user_database"


                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }
}