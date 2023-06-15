package home.codelab.myroutine.features.database.repository

import kotlinx.coroutines.flow.Flow
import home.codelab.myroutine.features.database.dao.MainRoutineDao
import home.codelab.myroutine.features.database.db.MainRoutineDatabase
import home.codelab.myroutine.features.database.entity.MainRoutineEntity

class MainRoutineRepository(private val mainRoutineDao: MainRoutineDao) {
    fun allStream(): Flow<List<MainRoutineEntity>> = mainRoutineDao.all()

    suspend fun insert(mainRoutineEntity: MainRoutineEntity) =
        mainRoutineDao.insert(mainRoutineEntity)

    suspend fun update(mainRoutineEntity: MainRoutineEntity) =
        mainRoutineDao.update(mainRoutineEntity)

    suspend fun delete(mainRoutineEntity: MainRoutineEntity) =
        mainRoutineDao.delete(mainRoutineEntity)

}