package home.codelab.myroutine.data.timetracker

import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.database.entity.RoutineEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.takeWhile
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.milliseconds


private val fullFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
private val diffFormat = SimpleDateFormat("yyyy лет MM месяцев dd дней HH:mm:ss")
fun String.toDateTime(): Date {
    var date: Date = try {
        fullFormat.parse(this)
    } catch (error: ParseException) {
        Date()
    }
    return date
}

abstract class TimeTracker(val routine: Routine) {
    private val begin = routine.start.toDateTime().time
    abstract val end: Long

    fun passedTime(): String {
        val diff = end - begin
        return diff.milliseconds.toComponents { days, hours, minutes, seconds, _ ->
            "$days дн. $hours ч. $minutes мин. $seconds сек."
        }
    }
    companion object {
        val now: String = fullFormat.format(Date())
    }
}

class InProgressTimeTracker(
    private val inProgressRoutine: RoutineEntity
) : TimeTracker(inProgressRoutine) {

    override val end: Long = Date().time

    private var inProgress = true
    fun stop() {
        inProgress = false
    }

    val everySecond: Flow<String> =
        flow {
            while (true) {
                delay(1000L)
                emit(passedTime())
            }
        }.takeWhile { _ -> inProgress }
}

class FinishedTimeTracker(private val finishedRoutine: RoutineEntity) :
    TimeTracker(finishedRoutine) {
    override val end: Long = routine.end?.toDateTime()?.time ?: Date().time
}