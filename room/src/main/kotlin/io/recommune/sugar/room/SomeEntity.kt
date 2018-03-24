package io.recommune.sugar.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
internal data class SomeEntity(@PrimaryKey val id: Long)