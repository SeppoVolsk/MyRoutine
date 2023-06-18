package home.codelab.myroutine.domain.routine


import android.content.Context
import home.codelab.myroutine.R
import home.codelab.myroutine.features.database.entity.RoutineEntity
import java.text.SimpleDateFormat
import java.util.Date

sealed class DefaultRoutine : Routine {
    fun toRoutineEntity() = RoutineEntity(
        that = this.that,
        start = this.start,
        end = this.end,
    )

    val now: String = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())

    class GoneCame(context: Context) : DefaultRoutine() {
        override val that: String = context.getString(R.string.gone_come)
        override val start: String = now
        override val end: String = "not finished yet"
    }
}
