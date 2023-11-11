package additional_package

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.ctis487_homework1.MovieReview
import com.example.ctis487_homework1.R

class ThirdActivity : AppCompatActivity() {

    lateinit var receivedMovie: MovieReview
    lateinit var thirdText: TextView
    lateinit var storyTellingText: TextView
    lateinit var movieName:TextView
    lateinit var cinematographyText: TextView
    lateinit var actingText: TextView
    lateinit var movieImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        movieName = findViewById(R.id.movieName)
        storyTellingText = findViewById(R.id.storyTelling)
        cinematographyText = findViewById(R.id.cinematography)
        actingText = findViewById(R.id.acting)

        movieImage = findViewById(R.id.movieImage)


        val rintent = intent
        val rb = rintent.extras
        val movie = rb!!.getParcelable("movie", MovieReview::class.java)!!
        thirdText = findViewById(R.id.thirdText)

        thirdText.setText(movie.name + "\n" + movie.storyTelling)


        val imageName = movie.name.toLowerCase().replace(" ", "")
        val resourceId = resources.getIdentifier(imageName, "drawable", packageName)
        movieImage.setImageResource(resourceId)


        movieName.setText(movie.name)
        storyTellingText.setText("Story Telling: " + movie.storyTelling)
        cinematographyText.setText("Cinematography: " + movie.cinematography)
        actingText.setText("Acting: " + movie.acting)

        /*receivedMovie = intent.getParcelableExtra<MovieReview>("movie")!!
        thirdText.setText(receivedMovie.name + "\n" + receivedMovie.storyTelling)*/



    }
}

