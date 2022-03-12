package com.example.recycleviewapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleviewapp.Views.FirstFragment
import com.example.recycleviewapp.Views.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            fragmentNavigation(supportFragmentManager, FirstFragment.newInstance("",""))
        }
    }
}