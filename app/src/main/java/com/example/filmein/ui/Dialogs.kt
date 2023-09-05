package com.example.filmein.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomAlertDialog(
    title: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit,
    confirmButton: @Composable () -> Unit,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
    ) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column {
                Column(Modifier.padding(24.dp)) {
                    title.invoke()
                    Spacer(Modifier.size(16.dp))
                    content.invoke()
                }
                Spacer(Modifier.size(4.dp))
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    Arrangement.spacedBy(8.dp, Alignment.End),
                ) {
                    dismissButton.invoke()
                    confirmButton.invoke()
                }
            }
        }
    }
}

@Composable
fun EnterTextDialog(
    title: @Composable () -> Unit,
    hint: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit,
    confirmButton: @Composable () -> Unit,
    onDismissRequest: () -> Unit,
    value: String,
    onNewText: (String) -> Unit
) {
    CustomAlertDialog(
        title = title,
        dismissButton = dismissButton,
        confirmButton = confirmButton,
        onDismissRequest = onDismissRequest) {
        OutlinedTextField(value = value, onValueChange = onNewText, label = hint, singleLine = true)
    }
}

@Preview
@Composable
fun EnterTextDialogPreview() {
    var text by remember { mutableStateOf("") }
    var shouldShowDialog by remember { mutableStateOf(true) }
    val textChanged: (String) -> Unit = { newText ->
        text = newText
    }
    val hideDialog = { shouldShowDialog = false }
    if (shouldShowDialog) {
        EnterTextDialog(
            title = { Text(text = "Movie / TV Show") },
            dismissButton = { TextButton(onClick = hideDialog) { Text("Dismiss") } },
            confirmButton = { TextButton(onClick = {
                hideDialog.invoke()
                println(text)
            }) { Text("Ok")} },
            hint = { Text("Title")},
            value = text,
            onNewText = textChanged,
            onDismissRequest = hideDialog
        )
    }
}