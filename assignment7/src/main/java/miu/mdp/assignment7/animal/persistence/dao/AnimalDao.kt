package miu.mdp.assignment7.animal.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import miu.mdp.assignment7.animal.persistence.database.TABLE_ANIMAL
import miu.mdp.assignment7.animal.persistence.entity.AnimalEntity

@Dao
interface AnimalDao : BaseDao<AnimalEntity> {

    @Query("""SELECT * FROM $TABLE_ANIMAL""")
    fun getAnimals(): Flow<List<AnimalEntity>>

}
