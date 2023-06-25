package home.codelab.myroutine.features.timetracker

import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.domain.routine.Routine
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

private val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")

class TimeTracker(val routine: Routine = DefaultRoutine.Undefined()) {

    private fun stringToDateTime(string: String): Date {
        return formatter.parse(string)
    }

    var seconds = 0
        private set

    fun passedTime() : Long {
         val begin = stringToDateTime(routine.start).time
         val now = Date().time
        println(Date(begin))
        println(Date(now))
        val diff = now - begin
        return TimeUnit.MILLISECONDS.toHours(diff)

    }

    private var everySecond: Timer? = null

    fun start() {
        everySecond = timer(
            startAt = stringToDateTime(routine.start),
            period = 1000L,
            daemon = false,
            action = {
                seconds++
                println(seconds)
            })
    }

    fun stop() {
        everySecond?.cancel()

    }


    companion object {
        val now: String = formatter.format(Date())
    }
}