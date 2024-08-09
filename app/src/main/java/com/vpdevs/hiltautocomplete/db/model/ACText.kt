package com.vpdevs.hiltautocomplete.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AutoCompleteText")
data class ACText(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "AutoCompleteTextName") val name: String
)
