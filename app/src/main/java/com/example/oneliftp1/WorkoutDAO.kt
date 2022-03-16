package com.example.oneliftp1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDAO  {

    @Query("SELECT * FROM workout_table ORDER BY workoutID ASC")
    fun getOrderedWorkouts():Flow<List<Workout>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(workout: Workout)

    @Query("SELECT * FROM exercise_table ORDER BY exerciseID ASC")
    fun getOrderedExercises(): Flow<List<Exercise>>

    @Query("SELECT workoutID FROM workout_table WHERE workout_title = :workout_title")
    suspend fun getWorkoutIdByTitle(workout_title: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exercise: Exercise)


}