package home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.tickerviewmodel.TickerViewModel

@Composable
fun TickerWidget(
    routine: Routine,
    tickerViewModel: TickerViewModel = viewModel<TickerViewModel>()
        .also { it.start(routine) }
) {
    val state by tickerViewModel.state.collectAsState()

    Column() {
        Text("${state.seconds}")
        Text("${state.duration}")
    }
}