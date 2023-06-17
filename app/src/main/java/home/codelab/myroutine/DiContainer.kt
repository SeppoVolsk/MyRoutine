package home.codelab.myroutine

import android.content.Context
import home.codelab.myroutine.features.database.db.RoutineDatabase
import home.codelab.myroutine.features.database.repository.RoutineRepository

class DiContainer(private val context: Context) {
    val mainRoutineRepository by lazy {
        RoutineRepository(RoutineDatabase.dbSingleExemplar(context).mainRoutineDao())
    }
}