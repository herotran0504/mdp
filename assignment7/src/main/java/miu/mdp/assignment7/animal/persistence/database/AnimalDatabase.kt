package miu.mdp.assignment7.animal.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import miu.mdp.assignment7.animal.persistence.dao.AnimalDao
import miu.mdp.assignment7.animal.persistence.dao.SpeciesDao
import miu.mdp.assignment7.animal.persistence.entity.AnimalEntity
import miu.mdp.assignment7.animal.persistence.entity.SpeciesEntity

@Database(
    entities = [
        AnimalEntity::class,
        SpeciesEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
    abstract fun speciesDao(): SpeciesDao

    companion object {

        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AnimalDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

}
