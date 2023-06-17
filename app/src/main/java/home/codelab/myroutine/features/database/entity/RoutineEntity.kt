package home.codelab.myroutine.features.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import home.codelab.myroutine.domain.routine.Routine

@Entity
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "that")
    override val that: String = "",
    @ColumnInfo(name = "start")
    override val start: String = "undefined",
    @ColumnInfo(name = "end")
    override val end: String = "in progress",
) : Routine