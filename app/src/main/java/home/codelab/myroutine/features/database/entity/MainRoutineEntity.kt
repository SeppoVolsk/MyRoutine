package home.codelab.myroutine.features.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity
data class MainRoutineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "that")
    val that: String = "",
    @ColumnInfo(name = "start")
    val start: String = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()),
    @ColumnInfo(name = "end")
    val end: String = "in progress",
    ){
    //var a = start.format(Date())
    }
