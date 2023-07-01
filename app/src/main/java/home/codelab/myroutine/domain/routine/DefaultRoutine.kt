package home.codelab.myroutine.domain.routine


import home.codelab.myroutine.data.timetracker.TimeTracker
import home.codelab.myroutine.features.database.entity.RoutineEntity

sealed class DefaultRoutine : Routine {
    fun toNewRoutineEntity() = RoutineEntity(
        that = this.that,
        start = this.start,
        end = this.end,
    )

    abstract fun copyWith(
        newThat: String? = null,
        newStart: String? = null,
        newEnd: String? = null
    ): DefaultRoutine

    data class GoneCame(
        override val that: String,
        override val start: String = TimeTracker.now,
        override val end: String? = null,
    ) : DefaultRoutine() {

        override fun copyWith(
            newThat: String?,
            newStart: String?,
            newEnd: String?
        ): DefaultRoutine {
            return DefaultRoutine.GoneCame(
                that = newThat ?: this.that,
                start = newStart ?: this.start,
                end = newEnd ?: this.end
            )
        }
    }

    class Undefined() : DefaultRoutine() {
        override val that: String = "Пустая рутина"
        override val start: String = "01/01/2023 12:00:00"
        override val end: String = "not finished yet"
        override fun copyWith(
            newThat: String?,
            newStart: String?,
            newEnd: String?
        ): DefaultRoutine = Undefined()
    }
}