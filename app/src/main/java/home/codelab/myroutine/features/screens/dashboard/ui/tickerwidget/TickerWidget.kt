package home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import home.codelab.myroutine.data.timetracker.InProgressTimeTracker

@Composable
fun TickerWidget(tracker: InProgressTimeTracker) {
   // val tracker = InProgressTimeTracker(routine)
    val everySecondStream = tracker.everySecond
        .collectAsState(initial = "...")
    val routineDuration = everySecondStream.value
    println("Value: $routineDuration")
//    val dashboardScreenViewModel = viewModel<DashboardScreenViewModel>()
//    val scope = rememberCoroutineScope()



    Column() {
        Text(text = routineDuration)
//        StopRoutineButton {
//            tracker.stop()
//            scope.launch {
//                dashboardScreenViewModel.finishRoutine(routine, TimeTracker.now)
//            }
//        }
    }
}


