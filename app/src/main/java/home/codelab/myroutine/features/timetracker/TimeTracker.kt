package home.codelab.myroutine.features.timetracker

import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.domain.routine.Routine
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import kotlin.concurrent.timer

private val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")

class TimeTracker(val routine: Routine = DefaultRoutine.Undefined()) {

    private fun stringToDateTime(string: String): Date {
        return formatter.parse(string)
    }

    var passedTime = 0
        private set

    private var everySecond: Timer? = null

    fun start() {
        everySecond = timer(
            startAt = stringToDateTime(routine.start),
            period = 1000L,
            daemon = false,
            action = {
                passedTime++
                println(passedTime)
            })
    }

    fun stop() {
        everySecond?.cancel()

    }




    companion object {
        val now: String = formatter.format(Date())
    }
}