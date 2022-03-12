package com.example.recycleviewapp.DataRoom

import android.media.metrics.Event
import androidx.room.*

@Dao
interface EventRoomDAO {
        @Query("SELECT * FROM eventosGuardados")
        fun getAll(): List<EventRoomEntity>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addEvent(event: Event)

        @Query("SELECT * FROM eventosGuardados WHERE title LIKE :title")
        fun findByTitle(title: String): EventRoomEntity

        @Insert
        fun insertAll(vararg todo: EventRoomEntity)

        @Delete
        fun delete(todo: EventRoomEntity)

        @Update
        fun updateTodo(vararg todos: EventRoomEntity)



}