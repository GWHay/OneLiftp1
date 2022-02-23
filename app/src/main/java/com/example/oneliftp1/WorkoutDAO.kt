package com.example.oneliftp1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout

@Dao
interface WorkoutDAO  {

    @Query("SELECT * FROM workout_table ORDER BY workoutID ASC")
    fun getOrderedWorkouts(): LiveData<List<Workout>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(workout: Workout)

    @Query("SELECT * FROM exercise_table ORDER BY exerciseID ASC")
    fun getOrderedExercises(): LiveData<List<Exercise>>

   // @Query("SELECT 1 FROM workout_table WHERE workoutID  ")

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exercise: Exercise)


}