import android.os.Bundle
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var tvFeedback: TextView? = null
    var rbStars: RatingBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvFeedback = findViewById(R.id.tvFeedback)
        rbStars = findViewById(R.id.rbStars)
        rbStars.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            if (rating == 0f) {
                tvFeedback.setText("Very Dissatisfied")
            } else if (rating == 1f) {
                tvFeedback.setText("Dissatisfied")
            } else if (rating == 2f) {
                tvFeedback.setText("OK")
            } else if (rating == 3f) {
                tvFeedback.setText("Satisfied")
            } else if (rating == 4f) {
                tvFeedback.setText("Very Satisfied")
            }
        }
        )
    }
}