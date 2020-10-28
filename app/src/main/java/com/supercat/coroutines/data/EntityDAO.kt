package com.supercat.coroutines.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityDAO {
    @Query("SELECT * FROM Entity")
    fun observeAllRows(): Flow<List<Entity>>

    @Insert
    suspend fun addElement(entity: Entity)
}
