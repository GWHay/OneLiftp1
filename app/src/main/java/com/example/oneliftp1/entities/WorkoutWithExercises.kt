package com.example.oneliftp1.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class WorkoutWithExercises(
    @Embedded val Workout: Workout,
    @Relation(parentColumn = "workoutID",
    entityColumn = "workoutExerciseID")
    val exercises: List<Exercise>
)