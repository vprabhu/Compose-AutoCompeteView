package com.vpdevs.hiltautocomplete.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vpdevs.hiltautocomplete.db.model.ACText
import kotlinx.coroutines.flow.Flow

@Dao
interface ACDao {

    @Query("select * from AutoCompleteText")
    fun getWordsList(): Flow<List<ACText>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWord(players: ACText)

}
