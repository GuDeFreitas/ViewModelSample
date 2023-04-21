package com.example.viewmodelsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//Presentation
class MyViewModel(
    private val repository: MyRepository
): ViewModel() {

    fun incrementOne() {
        repository.count = repository.count + 1
    }

    fun getCount(): Int{
        return repository.count
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {

                val repository = MyRepository()
                return MyViewModel(repository) as T
            }
        }
    }
}

// Data
class MyRepository(){
    var count = 0
}