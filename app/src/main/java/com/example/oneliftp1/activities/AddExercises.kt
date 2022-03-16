package com.example.oneliftp1.activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.oneliftp1.*
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope


class AddExercises : AppCompatActivity() {



    private val viewModel: OneLiftViewModel by viewModels{
        OneLiftViewModelFactory((application as OneLiftApplication).repository)
    }



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

        //val resultObserver = Observer<Int> { realID -> displayExercises.setText(realID)}
        viewModel.result.observe(this, { result -> displayWorkoutAuthor.setText(result)})





        displayWorkoutTitle.setText(workoutTitle.toString())
        displayWorkoutAuthor.setText(workoutAuthor.toString())

        btnAdd.setOnClickListener {
            val displayName = exerciseName.text.toString()
            val displayReps = reps.text.toString()
            val displaySets = sets.text.toString()
            val displayWeight = weight.text.toString()


            displayExercises.setText(displayName + " " + displayReps +" " + displaySets +" " + displayWeight)

            viewModel.addExerciseWithWID(workoutTitle.toString(),displayName.toString(), displayReps.toInt(),displaySets.toInt(),displayWeight.toDouble())
            Toast.makeText(this,"Exercise Added",Toast.LENGTH_LONG).show()

        }

        btnFinish.setOnClickListener{
            val intent = Intent(this@AddExercises, MainActivity::class.java)
            this.startActivity(intent)
        }




    }
}