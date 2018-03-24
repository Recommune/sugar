package io.recommune.sugar.room

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


inline fun <reified T : RoomDatabase> Context.roomInMemory(): RoomDatabase.Builder<T> {
    return Room.inMemoryDatabaseBuilder(this, T::class.java)
}

inline fun <reified T : RoomDatabase> Context.roomOnDisk(databaseName: String): RoomDatabase.Builder<T> {
    return Room.databaseBuilder(this, T::class.java, databaseName)
}