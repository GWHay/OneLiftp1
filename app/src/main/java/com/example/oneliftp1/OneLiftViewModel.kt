package com.example.oneliftp1

import android.util.Log
import androidx.lifecycle.*
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout
import kotlinx.coroutines.*
import kotlin.math.log

class OneLiftViewModel(private val repository: WorkoutRepository) : ViewModel() {

    val allWorkouts: LiveData<List<Workout>> = repository.allWorkouts.asLiveData()
    val allExercises: LiveData<List<Exercise>> = repository.allExercises.asLiveData()
    val result = MutableLiveData<Int>()


    fun insertWorkout(workout: Workout) = viewModelScope.launch {
        repository.insert(workout)
    }

    fun addNewWorkout(workoutId: Int, workoutTitle: String, workoutAuthor: String) {
        val newWorkout = getNewWorkout(workoutId, workoutTitle, workoutAuthor)
        insertWorkout(newWorkout)
    }

    fun getNewWorkout(workoutId: Int, workoutTitle: String, workoutAuthor: String): Workout {
        return Workout(
            workoutID = workoutId,
            workoutTitle = workoutTitle,
            workoutAuthor = workoutAuthor
        )
    }

    fun insertExercise(exercise: Exercise) = viewModelScope.launch {
        repository.insert(exercise)
    }

   fun addNewExercise(
        exerciseID: Int,
        workoutExerciseID: Int,
        exerciseTitle: String,
        repetitions: Int,
        sets: Int,
        weight: Double
    ) {
        val newExercise =
            getNewExercise(exerciseID, workoutExerciseID, exerciseTitle, repetitions, sets, weight)
        insertExercise(newExercise)
    }

    fun getNewExercise(
        exerciseID: Int,
        workoutExerciseID: Int,
        exerciseTitle: String,
        repetitions: Int,
        sets: Int,
        weight: Double
    ): Exercise {
        return Exercise(
            exerciseID = exerciseID,
            workoutExerciseID = workoutExerciseID,
            exerciseTitle = exerciseTitle,
            repetitions = repetitions,
            sets = sets,
            weight = weight
        )
    }

    fun addExerciseWithWID(workoutTitle: String, exerciseTitle: String, repetitions: Int,sets: Int,weight: Double) {


        viewModelScope.launch{
            val resultFrom = repository.getWorkoutIdByTitle(workoutTitle)
            addNewExercise(0, resultFrom, exerciseTitle,repetitions, sets, weight)
        }

    }


}

class OneLiftViewModelFactory(private val repository: WorkoutRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OneLiftViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OneLiftViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}