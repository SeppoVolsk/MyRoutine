package home.codelab.myroutine.domain

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.features.database.entity.RoutineEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DefaultRoutineTest {
    lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun toRoutineEntity() {
        val defaultRoutine = DefaultRoutine.GoneCame(context)
        assertEquals(
            defaultRoutine.toRoutineEntity(),
            RoutineEntity(
                id = 0,
                that = defaultRoutine.that,
                start = defaultRoutine.start,
                end = defaultRoutine.end
            )
        )
    }
}