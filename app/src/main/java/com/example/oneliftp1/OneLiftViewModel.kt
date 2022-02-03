package com.example.oneliftp1

import androidx.lifecycle.*
import com.example.oneliftp1.entities.Workout
import kotlinx.coroutines.launch

class OneLiftViewModel(private val workoutDAO: WorkoutDAO): ViewModel() {

    val allWorkouts: LiveData<List<Workout>> = workoutDAO.getOrderedWorkouts()

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