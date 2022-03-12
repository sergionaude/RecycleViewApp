package com.example.recycleviewapp.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventosGuardados")
data class EventRoomEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "title") var titleRoom: String,
    @ColumnInfo(name = "category") var categoryRoom: String,
    @ColumnInfo(name = "date") var dateRoom: String,

)




