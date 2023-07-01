package home.codelab.myroutine.features.database.repository

import home.codelab.myroutine.domain.routine.Routine
import home.codelab.myroutine.features.database.dao.RoutineDao
import home.codelab.myroutine.features.database.entity.RoutineEntity
import kotlinx.coroutines.flow.Flow

class RoutineRepository(private val mainRoutineDao: RoutineDao) {
    fun allStream(): Flow<List<RoutineEntity>> = mainRoutineDao.all()

    suspend fun insert(routine: RoutineEntity) {
        mainRoutineDao.insert(routine)
    }

    suspend fun update(routine: Routine) =
        mainRoutineDao.update(RoutineEntity.fromAnyRoutine(routine))

    suspend fun finish(routine: RoutineEntity, end: String) {
        val finishedRoutine = routine.copy(end = end)
        mainRoutineDao.update(finishedRoutine)
    }

    suspend fun delete(routine: Routine) =
        mainRoutineDao.delete(RoutineEntity.fromAnyRoutine(routine))

}