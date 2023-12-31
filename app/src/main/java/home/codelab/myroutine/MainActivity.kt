package home.codelab.myroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import home.codelab.myroutine.features.screens.dashboard.ui.DashboardScreen
import home.codelab.myroutine.ui.theme.MyRoutineTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRoutineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val tracker = TimeTracker()
//                    var i = 0
//                    Column {
//                        IconButton(onClick = { tracker.start() }) {
//                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
//                        }
//                        IconButton(onClick = { tracker.stop() }) {
//                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
//                        }
//                        Text(tracker.passedTime.toString())
//
//                    }


                    DashboardScreen()
                }
            }
        }
    }
}

