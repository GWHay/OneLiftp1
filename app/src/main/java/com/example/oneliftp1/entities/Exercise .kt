package com.example.oneliftp1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class Exercise (
    @PrimaryKey(autoGenerate = true) val exerciseID: Int,
    @ColumnInfo(name = "workoutExerciseID") val workoutExerciseID: Int,
    @ColumnInfo(name = "Exercise_title") val exerciseTitle: String,
    @ColumnInfo(name = "Repetitions") val repetitions: Int,
    @ColumnInfo(name = "Sets") val sets: Int,
    @ColumnInfo(name = "Weight") val weight: Double
)


