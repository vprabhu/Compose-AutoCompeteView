package com.vpdevs.hiltautocomplete.repository

import com.vpdevs.hiltautocomplete.db.dao.ACDao
import com.vpdevs.hiltautocomplete.db.model.ACText
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AcTextRepository @Inject constructor(private val acDao: ACDao) {

    suspend fun insertACSText(acText: ACText) {
        acDao.insertWord(acText)
    }

    val wordsList: Flow<List<ACText>> = acDao.getWordsList()

}
