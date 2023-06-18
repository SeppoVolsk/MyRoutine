package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import home.codelab.myroutine.R
import home.codelab.myroutine.domain.routine.Routine

@Composable
fun RoutineStateCard(routine: Routine, modifier: Modifier = Modifier) {
    val cardColor: Color = if (routine.end != null) {
        Color.Green
    } else {
        Color.Red
    }
    Card(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = cardColor)
    ) {
        Row(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Text(routine.that)
            Text(":")
            Text(routine.start)
            Text(stringResource(R.string.threeDotsHorizontal))
            Text(routine.end ?: "in progress")
        }
    }
}