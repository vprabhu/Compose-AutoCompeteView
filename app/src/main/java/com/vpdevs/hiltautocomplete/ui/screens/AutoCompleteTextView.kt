package com.vpdevs.hiltautocomplete.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AutoCompleteTextView(
    value: () -> String,
    onQueryChanged: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier

            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 32.dp),
        maxLines = 1,
        value = value(),
        onValueChange = { enteredString: String ->
            onQueryChanged(enteredString)
        },
        label = { Text("Enter Name") }
    )

}
