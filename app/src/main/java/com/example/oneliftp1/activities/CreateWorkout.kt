package com.example.oneliftp1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.oneliftp1.*

class CreateWorkout : AppCompatActivity() {

    val viewModel: OneLiftViewModel by viewModels{
        OneLiftViewModelFactory((this?.application as OneLiftApplication).database.WorkoutDAO())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)



        val btnNext = findViewById<Button>(R.id.btnNext)
        val workoutTitle = findViewById<TextView>(R.id.txtWorkoutTitle)
        val workoutAuthor = findViewById<TextView>(R.id.txtWorkoutAuthor)

        btnNext.setOnClickListener {

            val sendWT = workoutTitle.text.toString()
            val sendWA = workoutAuthor.text.toString()

            //viewModel.addNewWorkout(0, sendWT, sendWA)
            //viewModel.addNewExercise(0,0, "curl", 12,3,15.0)

            val intent = Intent(this@CreateWorkout, AddExercises::class.java)
            intent.putExtra("WorkoutTitle", sendWT)
            intent.putExtra("WorkoutAuthor", sendWA)
            this.startActivity(intent)





        }
    }
}