package com.example.oneliftp1.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_table")
data class
Workout(
    @PrimaryKey(autoGenerate = true) val workoutID: Int,
    @ColumnInfo(name = "workout_title") val workoutTitle: String,
    @ColumnInfo(name = "workout_author") val workoutAuthor: String
)


