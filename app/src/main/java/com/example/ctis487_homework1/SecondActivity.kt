package com.example.ctis487_homework1

import additional_package.ThirdActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var getterIntent: Intent
    lateinit var imageSP:ImageView
    lateinit var username:TextView
    lateinit var spinner:Spinner
    lateinit var stBar:SeekBar
    lateinit var ctBar:SeekBar
    lateinit var actBar:SeekBar
    lateinit var movie:MovieReview

    /*
    var godfatherMovie = MovieReview("Godfather")
    var interstellarMovie = MovieReview("Interstellar")
    var fightClubMovie = MovieReview("Fight Club")*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        stBar = findViewById(R.id.seekStory)
        ctBar = findViewById(R.id.seekCine)
        actBar = findViewById(R.id.seekAct)

        imageSP = findViewById(R.id.imageSP)
        spinner = findViewById(R.id.spinner)


        val imgIds = intArrayOf(R.drawable.godfather, R.drawable.interstellar,R.drawable.fightclub)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, i: Int, id: Long) {
                imageSP.setImageResource(imgIds[i])
                //println("heyo")
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }





        getterIntent = getIntent()
        val b = getterIntent.getExtras()

        val name = b!!.getString("name")
        val surname = b.getString("surname")
        val email = b.getString("email")
        username = findViewById(R.id.username)

        username.setText("Welcome!\n$name $surname\n$email")

        var intentSecond:Intent? = null
        intentSecond = Intent(this@SecondActivity, ThirdActivity::class.java)



        val switchButton : Button = findViewById(R.id.button2)
        switchButton.setOnClickListener {

            if(spinner.selectedItem.toString().equals("Godfather")){
                movie = MovieReview("Godfather", stBar.progress, ctBar.progress, actBar.progress)
            }else if(spinner.selectedItem.toString().equals("Interstellar")){
                movie = MovieReview("Interstellar", stBar.progress, ctBar.progress, actBar.progress)
            }else{
                movie = MovieReview("Fight Club", stBar.progress, ctBar.progress, actBar.progress)
            }
            intentSecond.putExtra("movie", movie)
            startActivity(intentSecond)
            setContentView(R.layout.activity_third)
        }

    }
}