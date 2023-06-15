package home.codelab.myroutine.features.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date

@Entity
data class MainRoutineEntity(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo(name = "that")
    val that: String = "",
    @ColumnInfo(name = "start")
    val start: SimpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss"),
    @ColumnInfo(name = "end")
    val end: LocalDateTime? = null,
    ){
    var a = start.format(Date())
    }
