package home.codelab.myroutine.features.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import home.codelab.myroutine.features.database.dao.RoutineDao
import home.codelab.myroutine.features.database.entity.RoutineEntity

@Database(entities = [RoutineEntity::class], version = 2)
abstract class RoutineDatabase : RoomDatabase() {
    abstract fun mainRoutineDao(): RoutineDao

    companion object {
        @Volatile
        private var instance: RoutineDatabase? = null

        fun dbSingleExemplar(context: Context): RoutineDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    RoutineDatabase::class.java,
                    "main_routine_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}