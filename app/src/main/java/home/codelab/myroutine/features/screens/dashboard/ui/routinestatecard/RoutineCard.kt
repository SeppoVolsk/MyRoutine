package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import home.codelab.myroutine.R
import home.codelab.myroutine.domain.routine.Routine


@Composable
fun RoutineCard(routine: Routine, modifier: Modifier = Modifier) {
    val isFinished = routine.end != null
    if (isFinished) {
        FinishedRoutineCard(routine)
    } else {
        InProgressRoutineCard(routine)
    }


}

@Composable
fun FinishedRoutineCard(routine: Routine, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.finished))
    ) {
        Row(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Text(routine.that)
            Text(":")
            Text(routine.start)
            Text(stringResource(R.string.threeDotsHorizontal))
            Text(routine.end ?: "")
        }
    }
}

@Composable
fun InProgressRoutineCard(routine: Routine, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.in_progress))
    ) {
        Row(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Text(routine.that)
            Text(":")
            Text(routine.start)
            Text(stringResource(R.string.threeDotsHorizontal))
            Text("in progress")
        }
    }

}


