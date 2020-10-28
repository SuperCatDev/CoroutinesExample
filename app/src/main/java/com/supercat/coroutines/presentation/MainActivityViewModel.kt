package com.supercat.coroutines.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supercat.coroutines.data.Repository
import kotlinx.coroutines.*

class MainActivityViewModel(private val repo: Repository) : ViewModel() {

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Example", throwable.stackTraceToString())
    }

    fun addElement() = viewModelScope.launch(errorHandler) {
        repo.addElement()
    }
}
