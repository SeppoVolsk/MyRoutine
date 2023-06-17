package home.codelab.myroutine.features.screens.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch


@Composable
fun DashboardScreen(
    viewModel: DashboardScreenViewModel = viewModel(
        factory = DashboardScreenViewModel.factory
    )
) {
    val scope = rememberCoroutineScope()
    val actualRoutine = DefaultRoutine.GoneCame(LocalContext.current)
    Column {
        Text(actualRoutine.that)
        FloatingActionButton(
            onClick = {
                scope.launch {
                    viewModel.addRoutine(
                        actualRoutine
                    )
                }
            }
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}