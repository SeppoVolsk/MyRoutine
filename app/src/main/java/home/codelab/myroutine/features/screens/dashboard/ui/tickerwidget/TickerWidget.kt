package home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard.StopButton
import home.codelab.myroutine.features.timetracker.TimeTracker

@Composable
fun TickerWidget(routine: Routine) {
    val tracker = TimeTracker(routine)
    val everySecondStream = tracker.everySecond
        .collectAsState(initial = "")
    val routineDuration = everySecondStream.value
    Column() {
        Text(text = routineDuration)
        StopButton {
            tracker.stop()
        }
    }
}

