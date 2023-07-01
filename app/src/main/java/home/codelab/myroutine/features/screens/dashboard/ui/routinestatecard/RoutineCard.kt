package home.codelab.myroutine.features.screens.dashboard.ui.routinestatecard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import home.codelab.myroutine.features.database.entity.RoutineEntity
import home.codelab.myroutine.features.screens.dashboard.ui.durationwidget.DurationWidget
import home.codelab.myroutine.features.screens.dashboard.ui.tickerwidget.TickerWidget


@Composable
fun RoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    val isFinished = routine.end != null
    if (isFinished) {
        FinishedRoutineCard(routine)
    } else {
        InProgressRoutineCard(routine)
    }


}

@Composable
fun FinishedRoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.finished))
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Text(routine.that)
            Text(routine.start)
            Text(stringResource(R.string.arrowDown), style = MaterialTheme.typography.titleLarge)
            Text(routine.end ?: "")
            DurationWidget(routine = routine)
        }
    }
}

@Composable
fun InProgressRoutineCard(routine: RoutineEntity, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_small)
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.in_progress))
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            Text(routine.that)
            Text(routine.start)
            Text(stringResource(R.string.arrowDown), style = MaterialTheme.typography.titleLarge)
            TickerWidget(routine = routine)
        }
    }

}


