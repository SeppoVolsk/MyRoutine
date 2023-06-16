package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import home.codelab.myroutine.MyRoutineApplication
import home.codelab.myroutine.features.database.entity.MainRoutineEntity
import home.codelab.myroutine.features.database.repository.MainRoutineRepository
import kotlinx.coroutines.flow.MutableStateFlow

class DashboardScreenViewModel(private val mainRoutineRepository: MainRoutineRepository) :
    ViewModel() {
    var someState = MutableStateFlow(0)
        private set

    suspend fun addRoutine() {
        mainRoutineRepository.insert(MainRoutineEntity(that = "Test routine"))
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