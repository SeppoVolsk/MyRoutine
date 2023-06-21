package home.codelab.myroutine.features.timetracker

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat

class TimeTrackerTest {


    @Test
    fun stringToDateTimeTest() {
        val tracker = TimeTracker()
        val dateTimeString = TimeTracker.now
        val dateTime = tracker.stringToDateTime(dateTimeString)
        val dateTimeToString = SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(dateTime)
        assertEquals(dateTimeString, dateTimeToString)
    }

    @Test
    fun timePassedTest() {
        val tracker = TimeTracker()
        var i = 0


    }

}
