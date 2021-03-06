package com.example.oneliftp1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.oneliftp1.R

class AddExercises : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exercises)

        val workoutTitle = intent.getStringExtra("WorkoutTitle")
        val workoutAuthor = intent.getStringExtra("WorkoutAuthor")
        val displayWorkoutTitle = findViewById<TextView>(R.id.txtDisplayWorkoutTitle)
        val displayWorkoutAuthor = findViewById<TextView>(R.id.txtDisplayWorkoutAuthor)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnFinish = findViewById<Button>(R.id.btnFinish)
        val exerciseName = findViewById<TextView>(R.id.txtExerciseName)
        val reps = findViewById<TextView>(R.id.txtReps)
        val sets = findViewById<TextView>(R.id.txtSets)
        val weight = findViewById<TextView>(R.id.txtWeight)
        val displayExercises = findViewById<TextView>(R.id.displayExercises)

        displayWorkoutTitle.setText(workoutTitle.toString())
        displayWorkoutAuthor.setText(workoutAuthor.toString())

        btnAdd.setOnClickListener {
            val displayName = exerciseName.text.toString()
            val displayReps = reps.text.toString()
            val displaySets = sets.text.toString()
            val displayWeight = weight.text.toString()

            displayExercises.setText(displayName + " " + displayReps +" " + displaySets +" " + displayWeight)


        }



    }
}