package com.example.oneliftp1

import androidx.lifecycle.*
import com.example.oneliftp1.entities.Exercise
import com.example.oneliftp1.entities.Workout
import kotlinx.coroutines.launch

class OneLiftViewModel(private val workoutDAO: WorkoutDAO): ViewModel() {

    val allWorkouts: LiveData<List<Workout>> = workoutDAO.getOrderedWorkouts()
    val allExercises: LiveData<List<Exercise>> = workoutDAO.getOrderedExercises()


    fun insertWorkout(workout: Workout) = viewModelScope.launch {
        workoutDAO.insert(workout)
    }

    fun addNewWorkout(workoutId: Int, workoutTitle: String, workoutAuthor: String){
        val newWorkout = getNewWorkout(workoutId, workoutTitle, workoutAuthor)
        insertWorkout(newWorkout)
    }

    fun getNewWorkout(workoutId: Int, workoutTitle: String, workoutAuthor: String): Workout {
        return Workout(workoutID = workoutId,workoutTitle = workoutTitle,workoutAuthor = workoutAuthor)
    }

    fun insertExercise(exercise: Exercise) = viewModelScope.launch {
        workoutDAO.insert(exercise)
    }

    fun addNewExercise(exerciseID: Int,workoutExerciseID: Int, exerciseTitle: String, repetitions: Int, sets: Int, weight: Double){
        val newExercise = getNewExercise(exerciseID, workoutExerciseID, exerciseTitle, repetitions, sets, weight)
        insertExercise(newExercise)
    }

    fun getNewExercise(exerciseID: Int,workoutExerciseID: Int, exerciseTitle: String, repetitions: Int, sets: Int, weight: Double): Exercise {
        return Exercise(exerciseID = exerciseID,workoutExerciseID = workoutExerciseID,exerciseTitle = exerciseTitle, repetitions = repetitions, sets = sets, weight = weight)
    }
    fun getWorkoutIdByTitle(workoutTitle: String): LiveData<Int> {
        return(workoutDAO.getWorkoutIdByTitle(workoutTitle))
    }


}

class OneLiftViewModelFactory(private val workoutDAO: WorkoutDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OneLiftViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OneLiftViewModel(workoutDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}