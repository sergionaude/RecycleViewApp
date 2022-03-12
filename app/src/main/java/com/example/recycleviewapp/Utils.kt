package com.example.recycleviewapp

import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.recycleviewapp.Model.Event
import com.example.recycleviewapp.Views.FirstFragment

fun fragmentNavigation(supportFragmentManager: FragmentManager, fragment: Fragment ){
    supportFragmentManager.beginTransaction()
        .replace(R.id.Contenedor, fragment)
        .addToBackStack(fragment.id.toString())
        .commit()
}

object MiLista{
    var eventos : MutableList<Event> = mutableListOf()

    fun agregar(event: Event){
        eventos.add(event)
    }

    fun ordenar(e: Event){
        eventos.sortedBy { e.Titulo
        }
    }

    fun quitar(event: Event){
        //eventos.clear()
        eventos.remove(event)
    }
}