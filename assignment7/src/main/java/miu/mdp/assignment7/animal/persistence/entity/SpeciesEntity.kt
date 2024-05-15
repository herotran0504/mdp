package miu.mdp.assignment7.animal.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import miu.mdp.assignment7.animal.persistence.database.TABLE_SPECIES

@Entity(tableName = TABLE_SPECIES)
data class SpeciesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String
)
