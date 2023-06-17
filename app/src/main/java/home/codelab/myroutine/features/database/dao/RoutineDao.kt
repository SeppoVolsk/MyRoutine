package home.codelab.myroutine.features.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import home.codelab.myroutine.features.database.entity.RoutineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(routine: RoutineEntity)

    @Update()
    suspend fun update(routine: RoutineEntity)

    @Delete
    suspend fun delete(routine: RoutineEntity)

    @Query(
        """
        SELECT * FROM RoutineEntity 
        ORDER BY id ASC    
        """
    )
    fun all(): Flow<List<RoutineEntity>>
}