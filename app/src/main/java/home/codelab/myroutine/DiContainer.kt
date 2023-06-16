package home.codelab.myroutine

import android.content.Context
import home.codelab.myroutine.features.database.db.MainRoutineDatabase
import home.codelab.myroutine.features.database.repository.MainRoutineRepository

class DiContainer(private val context: Context) {
    val mainRoutineRepository by lazy {
        MainRoutineRepository(MainRoutineDatabase.dbSingleExemplar(context).mainRoutineDao())
    }
}