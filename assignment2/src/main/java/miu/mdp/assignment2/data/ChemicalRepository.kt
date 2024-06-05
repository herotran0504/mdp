package miu.mdp.assignment2.data

import miu.mdp.assignment2.model.Chemical
import javax.inject.Inject

interface ChemicalRepository {
    suspend fun getChemicals(): List<Chemical>
    suspend fun addChemical(chemical: String)
}

internal class ChemicalRepositoryImpl @Inject constructor() : ChemicalRepository {

    override suspend fun getChemicals() = CHEMICALS

    override suspend fun addChemical(chemical: String) {
        CHEMICALS.add(Chemical(chemical))
    }

    companion object {
        internal val CHEMICALS = mutableListOf(
            Chemical("Aluminum"),
            Chemical("Gold"),
            Chemical("Selenium")
        )
    }
}
