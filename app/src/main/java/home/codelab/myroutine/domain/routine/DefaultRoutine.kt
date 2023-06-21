package home.codelab.myroutine.domain.routine


import android.content.Context
import home.codelab.myroutine.R
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.timetracker.TimeTracker

sealed class DefaultRoutine : Routine {
    fun toRoutineEntity() = RoutineEntity(
        that = this.that,
        start = this.start,
        end = this.end,
    )

    class GoneCame(context: Context) : DefaultRoutine() {
        override val that: String = context.getString(R.string.gone_come)
        override val start: String = TimeTracker.now
        override val end: String = "not finished yet"
    }

    class Undefined() : DefaultRoutine() {
        override val that: String = "Пустая рутина не требующая контекст"
        override val start: String = "01/01/2023 12:00:00"
        override val end: String = "not finished yet"

    }
}
