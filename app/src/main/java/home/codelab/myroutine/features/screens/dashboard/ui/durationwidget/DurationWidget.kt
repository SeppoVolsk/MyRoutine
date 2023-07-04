package home.codelab.myroutine.features.screens.dashboard.ui.durationwidget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import home.codelab.myroutine.data.timetracker.FinishedTimeTracker
import home.codelab.myroutine.features.database.entity.RoutineEntity

@Composable
fun DurationWidget(routine: RoutineEntity) {
    val tracker = FinishedTimeTracker(routine)
    Text(text = tracker.passedTime())
}