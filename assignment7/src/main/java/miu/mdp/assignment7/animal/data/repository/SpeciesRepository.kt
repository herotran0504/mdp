package miu.mdp.assignment7.animal.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import miu.mdp.assignment7.animal.data.Result
import miu.mdp.assignment7.animal.model.Species
import miu.mdp.assignment7.animal.persistence.dao.SpeciesDao
import miu.mdp.assignment7.animal.persistence.entity.SpeciesEntity
import javax.inject.Inject

interface SpeciesRepository {
    fun getSpecies(): Flow<Result<List<Species>>>

    suspend fun insertSpecies(species: Species): Result<Unit>
}

internal class SpeciesRepositoryImpl @Inject constructor(
    private val dao: SpeciesDao
) : SpeciesRepository {

    override fun getSpecies() = dao.getSpecies().map(::result)

    private fun result(entities: List<SpeciesEntity>) = try {
        Result.Success(entities.toModels())
    } catch (e: Exception) {
        Result.Error(e)
    }

    override suspend fun insertSpecies(species: Species) = try {
        dao.insert(species.toEntity())
        Result.Success(Unit)
    } catch (e: Exception) {
        Result.Error(e)
    }
}

private fun List<SpeciesEntity>.toModels() = this.map { it.toModels() }

private fun SpeciesEntity.toModels() = Species(
    name = name,
    description = description
)

private fun Species.toEntity() = SpeciesEntity(
    name = name,
    description = description
)