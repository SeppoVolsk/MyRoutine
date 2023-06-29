package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import home.codelab.myroutine.MyRoutineApplication
import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.database.repository.RoutineRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DashboardScreenViewModel(private val routineRepository: RoutineRepository) :
    ViewModel() {
    val dashboardScreenState: StateFlow<DashboardScreenState> =
        routineRepository.allStream().map { DashboardScreenState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DashboardScreenState()
            )

    suspend fun addRoutine(routine: Routine) {
        routineRepository.insert(routine)
    }

    suspend fun updateRoutine(routine: Routine) {
        routineRepository.update(routine)
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyRoutineApplication)
                DashboardScreenViewModel(application.diContainer.mainRoutineRepository)
            }
        }
    }
}