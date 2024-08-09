package com.vpdevs.hiltautocomplete.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AutoCompleteTextView(
    selectedText: () -> String,
    onQueryChanged: (String) -> Unit
) {

    var queryEntered by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 32.dp),
        maxLines = 1,
        value = queryEntered,
        onValueChange = { enteredString ->
            onQueryChanged(enteredString)
            queryEntered = enteredString
        },
        label = { Text("Enter Name") }
    )

}
