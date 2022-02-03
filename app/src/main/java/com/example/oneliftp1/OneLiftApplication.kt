package com.example.oneliftp1

import android.app.Application

class OneLiftApplication: Application() {
    val database by lazy { WorkoutRoomDatabase.getDatabase(this) }
}