import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.quizapplication.R

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        // Find the "Exit" button by its ID
        val buttonExit: Button = findViewById(R.id.buttonExit)

        // Set an OnClickListener to handle the button click
        buttonExit.setOnClickListener {
            Log.d("ResultsActivity", "button clicked") //logging button click for troubleshooting
            finishAffinity() // Exit the app
        }
    }
}


