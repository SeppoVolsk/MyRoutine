package home.codelab.myroutine.features.timetracker

import home.codelab.myroutine.data.timetracker.TimeTracker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TimeTrackerTest {


    @Test
    fun stringToDateTimeTest() {
        val tracker = TimeTracker()
        val dateTimeString = TimeTracker.now

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


}
