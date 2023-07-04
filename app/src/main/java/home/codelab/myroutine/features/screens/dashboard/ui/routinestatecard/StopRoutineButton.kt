package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun StopRoutineButton(onClick: () -> Unit) {


    TextButton(onClick = onClick) {
        Text("Остановить")
    }
}