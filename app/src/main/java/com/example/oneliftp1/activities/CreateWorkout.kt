package com.example.oneliftp1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.oneliftp1.R
import com.example.oneliftp1.WorkoutDAO
import com.example.oneliftp1.WorkoutRoomDatabase

class CreateWorkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)



        val btnNext = findViewById<Button>(R.id.btnNext)
        val workoutTitle = findViewById<TextView>(R.id.txtWorkoutTitle)
        val workoutAuthor = findViewById<TextView>(R.id.txtWorkoutAuthor)

        btnNext.setOnClickListener {

            val sendWT = workoutTitle.text.toString()
            val sendWA = workoutAuthor.text.toString()

            val intent = Intent(this@CreateWorkout, AddExercises::class.java)
            intent.putExtra("WorkoutTitle", sendWT)
            intent.putExtra("WorkoutAuthor", sendWA)
            this.startActivity(intent)





        }
    }
}