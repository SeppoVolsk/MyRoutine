package home.codelab.myroutine

import android.app.Application

class MyRoutineApplication : Application() {
    //private val database: MainRoutineDatabase = MainRoutineDatabase.dbSingleExemplar(this)
    lateinit var diContainer: DiContainer
    override fun onCreate() {
        super.onCreate()
        diContainer = DiContainer(this)
    }

}