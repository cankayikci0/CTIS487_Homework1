package com.example.ctis487_homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {


    private lateinit var txtName:EditText
    private lateinit var txtSurname:EditText
    private lateinit var txtEmail:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent:Intent? = null
        intent = Intent(this@MainActivity, SecondActivity::class.java)
        val startButton:Button = findViewById(R.id.startButton)

        txtName = findViewById(R.id.textName)
        txtSurname = findViewById(R.id.textSurname)
        txtEmail = findViewById(R.id.textEmail)


        startButton.setOnClickListener{

            val name = txtName.text.toString()
            val surname = txtSurname.text.toString()
            val email = txtEmail.text.toString()

            val b = Bundle()

            b.putString("name", name)
            b.putString("surname", surname)
            b.putString("email", email)


            intent.putExtras(b)
            startActivity(intent)
            setContentView(R.layout.second_activity)
        }

    }
}