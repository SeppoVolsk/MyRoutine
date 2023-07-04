package home.codelab.myroutine.domain

import home.codelab.myroutine.domain.routine.DefaultRoutine
import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultRoutineTest {
    @Test
    fun goneCome_copyWith_noParams() {
        val originalRoutine = DefaultRoutine.GoneCame("that", "start", "end")
        val copiedRoutine = originalRoutine.copyWith()
        assertEquals(originalRoutine, copiedRoutine)
    }

    @Test
    fun goneCome_copyWith_oneParam() {
        val originalRoutine = DefaultRoutine.GoneCame("that", "start", "end")
        val copiedRoutine = originalRoutine.copyWith(newEnd = "newEnd")
        assertEquals(copiedRoutine, DefaultRoutine.GoneCame("that", "start", "newEnd"))
    }

    @Test
    fun goneCome_copyWith_allParam() {
        val originalRoutine = DefaultRoutine.GoneCame("that", "start", "end")
        val copiedRoutine = originalRoutine.copyWith("newThat", "newStart", "newEnd")
        assertEquals(copiedRoutine, DefaultRoutine.GoneCame("newThat", "newStart", "newEnd"))
    }
}