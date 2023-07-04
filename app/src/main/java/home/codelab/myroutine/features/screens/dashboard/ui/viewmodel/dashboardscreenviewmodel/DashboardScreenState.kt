package home.codelab.myroutine.features.screens.dashboard.ui.viewmodel.dashboardscreenviewmodel

import home.codelab.myroutine.features.database.entity.RoutineEntity

data class DashboardScreenState(val routineList: List<RoutineEntity> = listOf())
