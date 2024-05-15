package miu.mdp.assignment7.animal.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import miu.mdp.assignment7.animal.data.Result
import miu.mdp.assignment7.animal.model.Animal
import miu.mdp.assignment7.animal.persistence.dao.AnimalDao
import miu.mdp.assignment7.animal.persistence.entity.AnimalEntity
import javax.inject.Inject

interface AnimalRepository {

    fun getAnimals(): Flow<Result<List<Animal>>>

    suspend fun insertAnimal(animal: Animal): Result<Unit>

}

internal class AnimalRepositoryImpl @Inject constructor(
    private val dao: AnimalDao
) : AnimalRepository {

    override fun getAnimals() = dao.getAnimals().map(::result)

    private fun result(entities: List<AnimalEntity>) = try {
        Result.Success(entities.toModels())
    } catch (e: Exception) {
        Result.Error(e)
    }

    override suspend fun insertAnimal(animal: Animal) = try {
        dao.insert(animal.toEntity())
        Result.Success(Unit)
    } catch (e: Exception) {
        Result.Error(e)
    }

}

private fun List<AnimalEntity>.toModels() = this.map { it.toModel() }

private fun AnimalEntity.toModel() = Animal(
    name = name, habitat = habitat, diet = diet
)

private fun Animal.toEntity() = AnimalEntity(
    name = name, habitat = habitat, diet = diet
)
