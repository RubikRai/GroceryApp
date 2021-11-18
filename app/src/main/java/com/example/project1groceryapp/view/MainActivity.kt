package com.example.project1groceryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project1groceryapp.R
import com.example.project1groceryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragLogin = LoginFragment()

    }
}