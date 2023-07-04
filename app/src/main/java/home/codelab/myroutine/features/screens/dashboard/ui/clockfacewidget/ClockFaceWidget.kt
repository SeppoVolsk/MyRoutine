package home.codelab.myroutine.features.screens.dashboard.ui.clockfacewidget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.sp
import home.codelab.myroutine.R
import kotlinx.coroutines.delay

@Composable
fun ClockFaceWidget() {
    var i by remember { mutableStateOf(0) }
    val clockFaces = stringArrayResource(id = R.array.clockFaces)
    LaunchedEffect(key1 = i) {
        delay(1000L)
        i++
        if (i == clockFaces.size) {
            i = 0
        }
    }
    Text(text = clockFaces[i], fontSize = 30.sp)
}
