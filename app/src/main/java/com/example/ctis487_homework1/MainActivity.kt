package com.example.ctis487_homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val switchButton: Button = findViewById(R.id.button2)
        switchButton.setOnClickListener {
            setContentView(R.layout.activity_second)
        }

    }
}