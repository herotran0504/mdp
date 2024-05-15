package miu.mdp.assignment7.animal.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import miu.mdp.assignment7.animal.persistence.database.TABLE_SPECIES
import miu.mdp.assignment7.animal.persistence.entity.SpeciesEntity

@Dao
interface SpeciesDao : BaseDao<SpeciesEntity> {

    @Query("""SELECT * FROM $TABLE_SPECIES""")
    fun getSpecies(): Flow<List<SpeciesEntity>>

}
