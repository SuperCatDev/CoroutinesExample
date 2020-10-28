package com.supercat.coroutines.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val randomId: Int,
)
