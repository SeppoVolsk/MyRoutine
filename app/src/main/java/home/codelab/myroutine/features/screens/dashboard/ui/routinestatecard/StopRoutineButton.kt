package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun StopRoutineButton(routine: Routine, toStop: () -> Unit) {
    val dashboardScreenViewModel = viewModel<DashboardScreenViewModel>()
    val scope = rememberCoroutineScope()
    IconButton(onClick = {
        toStop()

        scope.launch { dashboardScreenViewModel.updateRoutine(routine) }
    }) {
        Icon(
            imageVector = Icons.TwoTone.Close,
            contentDescription = null
        )
    }
}