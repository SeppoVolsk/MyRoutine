package home.codelab.myroutine.features.database.repository

import home.codelab.myroutine.domain.routine.DefaultRoutine
import home.codelab.myroutine.features.database.dao.RoutineDao
import home.codelab.myroutine.features.database.entity.RoutineEntity
import kotlinx.coroutines.flow.Flow

class RoutineRepository(private val mainRoutineDao: RoutineDao) {
    fun allStream(): Flow<List<RoutineEntity>> = mainRoutineDao.all()

    suspend fun insert(defaultRoutine: DefaultRoutine) {

        mainRoutineDao.insert(defaultRoutine.toRoutineEntity())
    }

    suspend fun update(routineEntity: RoutineEntity) =
        mainRoutineDao.update(routineEntity)

    suspend fun delete(routineEntity: RoutineEntity) =
        mainRoutineDao.delete(routineEntity)

}