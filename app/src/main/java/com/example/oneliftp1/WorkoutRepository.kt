package com.example.oneliftp1

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(private val workoutDAO: WorkoutDAO) {

    val allWorkouts: Flow<List<Workout>> = workoutDAO.getOrderedWorkouts()
    val allExercises: Flow<List<Exercise>> = workoutDAO.getOrderedExercises()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(workout:Workout){
        workoutDAO.insert(workout)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(exercise: Exercise){
        workoutDAO.insert(exercise)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getWorkoutIdByTitle(workoutTitle: String): Int {
        val queryResult = workoutDAO.getWorkoutIdByTitle(workoutTitle)
        Log.d("query result", queryResult.toString())
        return(queryResult)
    }

}