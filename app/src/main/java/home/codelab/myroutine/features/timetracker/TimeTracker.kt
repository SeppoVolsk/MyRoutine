package home.codelab.myroutine.features.timetracker

import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.domain.routine.Routine
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.takeWhile
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.milliseconds

private val fullFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
private val diffFormat = SimpleDateFormat("yyyy лет MM месяцев dd дней HH:mm:ss")

class TimeTracker(val routine: Routine = DefaultRoutine.Undefined()) {
    private val begin = stringToDateTime(routine.start).time
    private fun stringToDateTime(string: String): Date {
        return fullFormat.parse(string)
    }

    var isWorking = true
    fun stop() {
        isWorking = false
    }

    val everySecond: Flow<String> = flow {
        while (true) {
            delay(1000L)
            emit(passedTime())
            println(isWorking)
        }
    }.takeWhile { _ -> isWorking }


    private fun passedTime(): String {
        val now = Date().time
        val diff = now - begin
        return diff.milliseconds.toComponents { days, hours, minutes, seconds, _ ->
            "$days дн. $hours ч. $minutes мин. $seconds сек."
        }
    }

    companion object {
        val now: String = fullFormat.format(Date())
    }
}