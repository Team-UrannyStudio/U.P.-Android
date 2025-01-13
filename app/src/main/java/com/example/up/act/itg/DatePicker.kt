package com.example.up.act.itg

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun convertMillsToDate(millis : Long) : String {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    onDismiss : () -> Unit,
    onConfirm : (String) -> Unit,
    datePickerState: DatePickerState
){
    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismiss()
                    val day = convertMillsToDate(datePickerState.selectedDateMillis!!.toLong())
                    onConfirm(day)
                }
            ) {
                Text(text = "확인")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(text = "취소")
            }
        },
    ) {
        DatePicker(modifier = Modifier,
            state = datePickerState,
            showModeToggle = false,
        )
    }
}