package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun StopRoutineButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.TwoTone.Close,
            contentDescription = null
        )
    }
}