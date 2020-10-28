package com.supercat.coroutines.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supercat.coroutines.data.Entity
import com.supercat.coroutines.data.Repository
import com.supercat.coroutines.data.Status
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FirstFragmentViewModel(private val repo: Repository) : ViewModel() {

    private val elements = MutableLiveData<List<Int>>()
    private val showProgress = MutableLiveData<Boolean>()

    init {
        observeRows()
        observeStatus()
    }

    fun observeElements(): LiveData<List<Int>> = elements
    fun observeShowProgress(): LiveData<Boolean> = showProgress

    private fun observeRows() = viewModelScope.launch {
        repo.observeAllRows()
            .collect { rows: List<Entity> ->
                elements.value = rows.map { it.randomId }
            }
    }

    private fun observeStatus() = viewModelScope.launch {
        repo.observeStatus()
            .collect {
                showProgress.value = it != Status.IDLE
            }
    }
}
