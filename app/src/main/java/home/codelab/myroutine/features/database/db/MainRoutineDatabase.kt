package home.codelab.myroutine.features.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import home.codelab.myroutine.features.database.dao.MainRoutineDao
import home.codelab.myroutine.features.database.entity.MainRoutineEntity

@Database(entities = [MainRoutineEntity::class], version = 1)
abstract class MainRoutineDatabase : RoomDatabase() {
    abstract fun mainRoutineDao(): MainRoutineDao

    companion object {
        @Volatile
        private var INSTANCE: MainRoutineDatabase? = null

        fun dbSingleExemplar(context: Context): MainRoutineDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MainRoutineDatabase::class.java,
                    "main_routine_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}