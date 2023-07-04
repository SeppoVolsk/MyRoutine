package home.codelab.myroutine.features.screens.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.R
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard.RoutineCard
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch


@ExperimentalMaterial3Api
@Composable
fun DashboardScreen(
    viewModel: DashboardScreenViewModel = viewModel(
        factory = DashboardScreenViewModel.factory
    )
) {
    val state by viewModel.dashboardScreenState.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val defaultRoutineTitle = context.getString(R.string.gone_come)
    Scaffold(
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    items = state.routineList
                ) { routine ->
                    RoutineCard(routine)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
//                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    scope.launch {
                        viewModel.addRoutine(
                            RoutineEntity(that = defaultRoutineTitle)
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
    )
}