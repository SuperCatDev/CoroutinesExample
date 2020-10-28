package com.supercat.coroutines.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import kotlin.random.Random

enum class Status {
    IDLE,
    DATA_INSERTING
}

@Suppress("EXPERIMENTAL_API_USAGE")
class Repository(private val dao: EntityDAO) {

    private val state = MutableStateFlow(Status.IDLE)

    suspend fun addElement() {
        state.value = Status.DATA_INSERTING
        delay(3000)
        Log.i("VVV2", Thread.currentThread().name)
        withContext(Dispatchers.IO) {
            dao.addElement(Entity(randomId = Random.nextInt()))
        }
        state.value = Status.IDLE
    }

    fun observeStatus(): Flow<Status> = state

    fun observeAllRows(): Flow<List<Entity>> = dao.observeAllRows()
}
