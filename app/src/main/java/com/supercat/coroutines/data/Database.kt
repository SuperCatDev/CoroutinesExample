package com.supercat.coroutines.data

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "SimpleDB"

@Database(
    entities = [
        Entity::class
    ],
    version = DATABASE_VERSION
)
abstract class Database : RoomDatabase() {
    abstract fun getEntityDao(): EntityDAO
}
