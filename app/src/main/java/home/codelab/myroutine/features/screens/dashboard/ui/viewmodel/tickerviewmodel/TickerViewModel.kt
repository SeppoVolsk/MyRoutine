package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.tickerviewmodel

import androidx.lifecycle.ViewModel
import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.timetracker.TimeTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TickerViewModel : ViewModel() {
    private val _state = MutableStateFlow(TickerWidgetState())
    val state: StateFlow<TickerWidgetState> = _state.asStateFlow()


    fun start(routine: Routine) {
        val tracker = TimeTracker(routine)
        tracker.start()
        _state.update {
            TickerWidgetState(
                //seconds = tracker.seconds,
                duration = tracker.passedTime().toString()
            )
        }
    }

}


data class TickerWidgetState(
    val seconds: Int = 0,
    val duration: String = ""
)