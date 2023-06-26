package home.codelab.myroutine.features.timetracker

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
        runBlocking {
            val job = launch { tracker.everySecond.collect { seconds -> println(seconds) } }
            launch {
                delay(5000L)
                job.cancel()
            }
        }

    }

    @Test
    fun passedTimeTest() {
        val tracker = TimeTracker()
        tracker.passedTime()
    }
}
