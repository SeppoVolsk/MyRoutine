package home.codelab.myroutine.features.screens.dashboard.ui.keycapsdigitswidget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import home.codelab.myroutine.R

@Composable
fun KeyCapsDigitsWidget(number: Int) {
    val digitsString = number.toString()
    val keyCaps = stringArrayResource(id = R.array.keyCaps)


    Row() {
        for (numChar in digitsString) {
            Text(keyCaps[numChar.digitToInt()])
        }
    }
}