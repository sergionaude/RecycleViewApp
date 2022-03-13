package com.example.recycleviewapp.DataRoom

import androidx.room.*
import com.example.recycleviewapp.Model.Event

/**
 * There is no need of create a new data class for the database objects
 * You can use the same [Event]
 *
 * Now, let's use the database using RxJava
 */
@Dao
interface EventRoomDAO {

        @Query("SELECT * FROM event")
        fun getAll(): List<Event>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addEvent(event: Event)

        @Query("SELECT * FROM event WHERE Titulo LIKE :title")
        fun findByTitle(title: String): Event

        @Insert
        fun insertAll(vararg todo: Event)

        @Delete
        fun delete(todo: Event)

        @Update
        fun updateTodo(vararg todos: Event)



}