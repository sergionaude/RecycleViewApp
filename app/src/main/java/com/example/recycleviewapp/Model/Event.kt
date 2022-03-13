package com.example.recycleviewapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event (
    @PrimaryKey
    val Titulo : String,
    val Categoria : String,
    val Fecha : String
)