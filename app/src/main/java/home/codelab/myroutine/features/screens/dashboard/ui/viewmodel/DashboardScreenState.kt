package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel

import home.codelab.myroutine.domain.routine.Routine

data class DashboardScreenState(val routineList: List<Routine> = listOf())
