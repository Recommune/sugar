package io.recommune.sugar.room

import android.arch.persistence.room.RoomDatabase
import android.content.Context

abstract class RoomAbstractDatabase {

    protected abstract val database: RoomDatabase

    sealed class Builder(val context: Context) {

        class Memory(context: Context) : Builder(context)

        class Disk(context: Context, val databaseName: String) : Builder(context)
    }
}
