package home.codelab.myroutine

import android.app.Application
import home.codelab.myroutine.features.database.db.MainRoutineDatabase

class MyRoutineApplication : Application() {
    val database: MainRoutineDatabase by lazy { MainRoutineDatabase.dbSingleExemplar(this) }
}