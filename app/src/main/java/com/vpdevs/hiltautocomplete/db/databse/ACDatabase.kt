package com.vpdevs.hiltautocomplete.db.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vpdevs.hiltautocomplete.db.dao.ACDao
import com.vpdevs.hiltautocomplete.db.model.ACText

@Database(entities = [ACText::class], version = 1, exportSchema = false)
abstract class ACDatabase : RoomDatabase() {

    abstract val acDao: ACDao

}