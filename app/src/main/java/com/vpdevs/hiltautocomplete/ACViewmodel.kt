package com.vpdevs.hiltautocomplete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vpdevs.hiltautocomplete.db.model.ACText
import com.vpdevs.hiltautocomplete.repository.AcTextRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ACViewmodel @Inject constructor(
    private val acTextRepository: AcTextRepository
) : ViewModel() {

    private val _playerList = MutableStateFlow(arrayListOf<ACText>())
    val playerList = _playerList.asStateFlow()

    fun getALlWordsList() {
        viewModelScope.launch {
            acTextRepository.wordsList.collect {
                _playerList.value = it as ArrayList<ACText>
            }
        }
    }

    fun insertWord(word: String) {
        viewModelScope.launch {
            val newWord = ACText(
                name = word
            )
            acTextRepository.insertACSText(newWord)

        }
    }

}
