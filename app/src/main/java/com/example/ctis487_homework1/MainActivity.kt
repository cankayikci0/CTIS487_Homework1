package com.example.ctis487_homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {


    private lateinit var txtName:EditText
    private lateinit var txtSurname:EditText
    private lateinit var txtEmail:EditText
    private lateinit var blinkingTitle:TextView
    private lateinit var exitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent:Intent? = null
        intent = Intent(this@MainActivity, SecondActivity::class.java)
        val startButton:Button = findViewById(R.id.startButton)

        txtName = findViewById(R.id.textName)
        txtSurname = findViewById(R.id.textSurname)
        txtEmail = findViewById(R.id.textEmail)
        blinkingTitle = findViewById(R.id.blinkingTitle)
        exitButton = findViewById(R.id.exitButton)


        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE


        // Start the animation
        blinkingTitle.startAnimation(anim)

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
        exitButton.setOnClickListener {
            val alertdialog : AlertDialog = AlertDialog.Builder(this).create()
            alertdialog.setTitle("Exit")
            alertdialog.setMessage("Do you want to exit?")

            alertdialog.setButton(AlertDialog.BUTTON_POSITIVE,"Yes"){
                dialog, which ->finish()
            }
            alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                dialog, which ->
            }
            alertdialog.show()

        }

    }
}