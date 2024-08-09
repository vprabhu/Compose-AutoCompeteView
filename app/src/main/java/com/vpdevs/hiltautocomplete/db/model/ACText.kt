package com.vpdevs.hiltautocomplete.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlin.math.truncate

@Entity(
    tableName = "AutoCompleteText",
    indices = [Index(value = ["AutoCompleteTextName"], unique = true)]
)
data class ACText(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "AutoCompleteTextName") val name: String
)
