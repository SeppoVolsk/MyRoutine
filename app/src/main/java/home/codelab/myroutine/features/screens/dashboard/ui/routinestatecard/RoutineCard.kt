package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.R
import home.codelab.myroutine.data.timetracker.InProgressTimeTracker
import home.codelab.myroutine.data.timetracker.TimeTracker
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.screens.dashboard.ui.clockfacewidget.ClockFaceWidget
import home.codelab.myroutine.features.screens.dashboard.ui.durationwidget.DurationWidget
import home.codelab.myroutine.features.screens.dashboard.ui.keycapsdigitswidget.KeyCapsDigitsWidget
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel.DashboardScreenViewModel
import kotlinx.coroutines.launch


@Composable
fun RoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    val isFinished = routine.end != null
    if (isFinished) {
        FinishedRoutineCard(routine)
    } else {
        InProgressRoutineCard(routine)
    }


}

@Composable
fun FinishedRoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.finished))
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                KeyCapsDigitsWidget(routine.id)
            }
            Text(routine.that)
            Text(routine.start)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.greenDone),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.width(10.dp))
                DurationWidget(routine = routine)
            }
            Text(routine.end ?: "")
        }
    }
}

@Composable
fun InProgressRoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    val dashboardScreenViewModel = viewModel<DashboardScreenViewModel>()
    val scope = rememberCoroutineScope()
    val tracker = InProgressTimeTracker(routine)
    val everySecondStream = tracker.everySecond
        .collectAsState(initial = "")
    val routineDuration = everySecondStream.value
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.in_progress))
    ) {

        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                KeyCapsDigitsWidget(routine.id)
            }
            Text(routine.that)
            Text(routine.start)
            Row(verticalAlignment = Alignment.CenterVertically) {
                ClockFaceWidget()
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = routineDuration)
                //TickerWidget(tracker)
            }
            StopRoutineButton {
                tracker.stop()
                scope.launch {
                    dashboardScreenViewModel.finishRoutine(routine, TimeTracker.now)
                }
            }
        }
    }

}


