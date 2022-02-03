package com.example.oneliftp1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout

@Database(entities = [Workout :: class, Exercise::class], version = 2, exportSchema = false)
abstract class WorkoutRoomDatabase : RoomDatabase(){
abstract fun WorkoutDAO(): WorkoutDAO

companion object {
    @Volatile
    private var INSTANCE: WorkoutRoomDatabase? = null

    fun getDatabase(context: Context): WorkoutRoomDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                WorkoutRoomDatabase::class.java,
                "workout_database"
            ).fallbackToDestructiveMigration().build()
            INSTANCE = instance
            return instance
        }
    }
}
}


