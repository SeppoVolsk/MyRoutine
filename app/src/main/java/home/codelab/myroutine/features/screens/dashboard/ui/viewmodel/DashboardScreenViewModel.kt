package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import home.codelab.myroutine.MyRoutineApplication
import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.features.database.repository.RoutineRepository
import kotlinx.coroutines.flow.MutableStateFlow

class DashboardScreenViewModel(private val mainRoutineRepository: RoutineRepository) :
    ViewModel() {
    var someState = MutableStateFlow(0)
        private set

    suspend fun addRoutine(routine: DefaultRoutine) {
        mainRoutineRepository.insert(routine)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyRoutineApplication)
                DashboardScreenViewModel(application.diContainer.mainRoutineRepository)
            }
        }
    }
}