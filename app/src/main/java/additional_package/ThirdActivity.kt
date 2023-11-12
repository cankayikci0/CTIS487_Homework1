package additional_package

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.ctis487_homework1.MainActivity
import com.example.ctis487_homework1.R

class ThirdActivity : AppCompatActivity() {

    lateinit var receivedMovie: MovieReview
    lateinit var thirdText: TextView
    lateinit var storyTellingText: TextView
    lateinit var movieName:TextView
    lateinit var cinematographyText: TextView
    lateinit var actingText: TextView
    lateinit var movieImage: ImageView
    lateinit var totalScoreView: TextView
    lateinit var cultText: TextView
    lateinit var backButton: Button
    lateinit var movieReviews: MutableList<MovieReview>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        movieName = findViewById(R.id.movieName)
        storyTellingText = findViewById(R.id.storyTelling)
        cinematographyText = findViewById(R.id.cinematography)
        actingText = findViewById(R.id.acting)
        totalScoreView = findViewById(R.id.totalScoreView)
        cultText = findViewById(R.id.cultText)
        backButton = findViewById(R.id.backButton)
        movieImage = findViewById(R.id.movieImage)


        val rintent = intent
        val rb = rintent.extras
        val movie = rb!!.getParcelable("movie", MovieReview::class.java)!!
        thirdText = findViewById(R.id.thirdText)

        thirdText.setText("Your Movie Review")
        val backIntent = Intent(this@ThirdActivity, MainActivity::class.java)

        val imageName = movie.name.toLowerCase().replace(" ", "")
        val resourceId = resources.getIdentifier(imageName, "drawable", packageName)
        movieImage.setImageResource(resourceId)


        movieName.setText(movie.name)
        storyTellingText.setText("Story Telling: " + movie.storyTelling)
        cinematographyText.setText("Cinematography: " + movie.cinematography)
        actingText.setText("Acting: " + movie.acting)

        totalScoreView.setText("Its Score is: " + calculateTotalPoints(movie))

        cultText.setText(MovieReview.getDefaultMovieReview(calculateTotalPoints(movie)))

        makeAndShowDialog(MovieReview.getDefaultMovieReview(calculateTotalPoints(movie))
                          + "\nMovie's score is ${calculateTotalPoints(movie)}"
                          + "\nDefault Score is ${MovieReview.COMMON_SCORE}"

        )
        backButton.setOnClickListener{
            startActivity(backIntent)
            displayMovieReviewsToLogcat()
        }

        movieReviews = mutableListOf(movie)
        /*receivedMovie = intent.getParcelableExtra<MovieReview>("movie")!!
        thirdText.setText(receivedMovie.name + "\n" + receivedMovie.storyTelling)*/
    }
    private fun makeAndShowDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Movie's Review")
        builder.setMessage(message)
        builder.setPositiveButton("Close") { dialog, which ->
        }
        builder.create()
        builder.show()
    }
    private fun calculateTotalPoints(movie: MovieReview): Double {

        val storyTellingPoints = movie.storyTelling
        val cinematographyPoints = movie.cinematography
        val actingPoints = movie.acting

        // Calculate total points
        return (storyTellingPoints * 1.0 * 53 / 100) + (cinematographyPoints * 22 / 100 ) + (actingPoints* 25 / 100)
    }

    private fun displayMovieReviewsToLogcat() {
        for ((index, review) in movieReviews.withIndex()) {
            Log.d("MovieReview", "Review $index: ${review.displayReview()}")
        }
    }

}

