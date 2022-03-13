package com.example.recycleviewapp.DataRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabase.Builder
import com.example.recycleviewapp.Model.Event

//@ Database(entities = arrayOf(EventRoomEntity::class), version = 1)
@Database(entities = [Event::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao() : EventRoomDAO

    /**
     * This is how you make this thread-safe
     */
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context):AppDatabase{
            val tempInstance = INSTANCE

            tempInstance?.let {
                return it
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Event_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}