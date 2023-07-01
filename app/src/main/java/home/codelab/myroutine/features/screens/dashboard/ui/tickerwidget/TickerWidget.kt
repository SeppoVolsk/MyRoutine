package home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.data.timetracker.InProgressTimeTracker
import home.codelab.myroutine.data.timetracker.TimeTracker
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard.StopRoutineButton
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun TickerWidget(routine: RoutineEntity) {
    val tracker = InProgressTimeTracker(routine)
    val everySecondStream = tracker.everySecond
        .collectAsState(initial = "")
    val routineDuration = everySecondStream.value
    val dashboardScreenViewModel = viewModel<DashboardScreenViewModel>()
    val scope = rememberCoroutineScope()
    Column() {
        Text(text = routineDuration)
        StopRoutineButton {
            tracker.stop()
            scope.launch {
                dashboardScreenViewModel.finishRoutine(routine, TimeTracker.now)
            }
        }
    }
}

