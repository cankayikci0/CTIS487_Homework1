package additional_package

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.ctis487_homework1.MovieReview
import com.example.ctis487_homework1.R

class ThirdActivity : AppCompatActivity() {

    lateinit var receivedMovie: MovieReview
    lateinit var thirdText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val rintent = intent
        val rb = rintent.extras
        val movie = rb!!.getParcelable("movie", MovieReview::class.java)!!
        thirdText = findViewById(R.id.thirdText)

        thirdText.setText(movie.name + "\n" + movie.storyTelling)

        /*receivedMovie = intent.getParcelableExtra<MovieReview>("movie")!!
        thirdText.setText(receivedMovie.name + "\n" + receivedMovie.storyTelling)*/



    }
}