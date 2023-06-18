package home.codelab.myroutine.features.screens.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard.RoutineStateCard
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch


@Composable
fun DashboardScreen(
    viewModel: DashboardScreenViewModel = viewModel(
        factory = DashboardScreenViewModel.factory
    )
) {
    val state by viewModel.dashboardScreenState.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = state.routineList,
            ) { routine ->
                RoutineStateCard(routine)
            }
        }
        FloatingActionButton(
            shape = MaterialTheme.shapes.medium,
            onClick = {
                scope.launch {
                    viewModel.addRoutine(
                        DefaultRoutine.GoneCame(context)
                    )
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}