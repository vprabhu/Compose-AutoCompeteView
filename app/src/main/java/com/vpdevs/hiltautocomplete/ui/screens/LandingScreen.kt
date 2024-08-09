package com.vpdevs.hiltautocomplete.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vpdevs.hiltautocomplete.ACViewmodel
import com.vpdevs.hiltautocomplete.db.model.ACText


@SuppressLint("MutableCollectionMutableState")
@Composable
fun LandingScreen(
    acViewmodel: ACViewmodel = viewModel()
) {

    val queryList: MutableState<ArrayList<ACText>> = remember {
        mutableStateOf(ArrayList())
    }

    var selectedItem by remember { mutableStateOf("") }

    var addNewItem by remember { mutableStateOf(false) }

    var isSuggestionListShown by remember { mutableStateOf(false) }

    val wordsList by acViewmodel.playerList.collectAsState()
    acViewmodel.getALlWordsList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AutoCompleteTextView({ selectedItem }) { query ->
            Log.d(
                "LandingScreen",
                "LandingScreen:onQueryChanged : $query"
            )
            if (query.isEmpty()) {
                isSuggestionListShown = true
                addNewItem = false
                queryList.value.clear()
            }
            val isThere = wordsList.filter {
                it.name.contains(query)
            }
            if (isThere.isEmpty()) {
                Log.d(
                    "LandingScreen",
                    "LandingScreen:onQueryChanged -->  create new :$query"
                )
                addNewItem = true
                val tempList = ArrayList<ACText>()
                val acText = ACText(name = query)
                tempList.add(acText)
                queryList.value = tempList
            } else {
                queryList.value = wordsList.filter {
                    it.name.contains(query)
                } as ArrayList<ACText>
            }

            Log.d(
                "LandingScreen",
                "LandingScreen:queryList.value -->  ${queryList.value}"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = isSuggestionListShown) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                items(count = queryList.value.size) {
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                            Log.d(
                                "LandingScreen",
                                "LandingScreen:TextButton : ${queryList.value[it]}"
                            )
                            if (addNewItem) {
                                acViewmodel.insertWord(queryList.value[it].name)
                                addNewItem = false
                            }
                            selectedItem = queryList.value[it].name
                            isSuggestionListShown = false
                        }) {
                        val text = if (addNewItem) {
                            "create new :${queryList.value[it].name}"
                        } else {
                            queryList.value[it].name
                        }
                        Text(text = text)
                    }
                    HorizontalDivider(thickness = 1.dp, color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }

    }

}
