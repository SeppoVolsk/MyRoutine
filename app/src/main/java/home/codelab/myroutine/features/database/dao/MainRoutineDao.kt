package home.codelab.myroutine.features.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import home.codelab.myroutine.features.database.entity.MainRoutineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MainRoutineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(routine: MainRoutineEntity)

    @Update()
    suspend fun update(routine: MainRoutineEntity)

    @Delete
    suspend fun delete(routine: MainRoutineEntity)

    @Query(
        """
        SELECT * FROM MainRoutineEntity 
        ORDER BY id ASC    
        """
    )
    fun all(): Flow<List<MainRoutineEntity>>
}