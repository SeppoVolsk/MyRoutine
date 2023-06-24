package home.codelab.myroutine.features.timetracker

import org.junit.Test

class TimeTrackerTest {


    @Test
    fun stringToDateTimeTest() {
        val tracker = TimeTracker()
        val dateTimeString = TimeTracker.now
        // val dateTime = tracker.stringToDateTime(dateTimeString)
       // val dateTimeToString = SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(dateTime)
       // assertEquals(dateTimeString, dateTimeToString)
    }

    @Test
    fun secondsTest() {
        val tracker = TimeTracker()
        var i = 0

    }

    @Test
    fun passedTimeTest() {
        val tracker = TimeTracker()
        tracker.passedTime()
    }
}
