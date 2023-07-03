package home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.R
import home.codelab.myroutine.data.timetracker.InProgressTimeTracker
import home.codelab.myroutine.data.timetracker.TimeTracker
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard.StopRoutineButton
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel.DashboardScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TickerWidget(routine: RoutineEntity) {
    val tracker = InProgressTimeTracker(routine)
    val everySecondStream = tracker.everySecond
        .collectAsState(initial = "...")
    val routineDuration = everySecondStream.value
    val dashboardScreenViewModel = viewModel<DashboardScreenViewModel>()
    val scope = rememberCoroutineScope()
    println("TickerWidget called")


    Column {
        Row {

            Box(Modifier.background(color = Color.Gray)) {
                InfinityProgressWidget()
            }
            Text(text = routineDuration)
        }
        StopRoutineButton {
            tracker.stop()
            scope.launch {
                dashboardScreenViewModel.finishRoutine(routine, TimeTracker.now)
            }
        }
    }
}

@Composable
fun InfinityProgressWidget() {
    var len by remember { mutableStateOf(0) }
    var bar = ""
    val barElement = stringResource(id = R.string.doubleTriangleRight)

    LaunchedEffect(key1 = len) {
        println(len)
        delay(1000L)
        len++
        if (len > 5) {
            len = 1
            bar = ""
        }

    }

    repeat(len) { bar += barElement }
    Text(text = bar)
}

