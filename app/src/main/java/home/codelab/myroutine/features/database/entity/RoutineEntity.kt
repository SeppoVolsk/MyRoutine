package home.codelab.myroutine.features.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import home.codelab.myroutine.data.timetracker.TimeTracker
import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.domain.routine.Routine

@Entity
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "that")
    override val that: String = "Unnamed routine",
    @ColumnInfo(name = "start")
    override val start: String = TimeTracker.now,
    @ColumnInfo(name = "end")
    override val end: String? = null,
) : Routine {
    companion object {
        fun fromAnyRoutine(routine: Routine): RoutineEntity {
            return when (routine) {
                is DefaultRoutine -> routine.toNewRoutineEntity()
                else -> RoutineEntity()
            }
        }
    }
}
