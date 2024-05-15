package miu.mdp.assignment7.animal.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import miu.mdp.assignment7.animal.persistence.database.TABLE_ANIMAL

@Entity(tableName = TABLE_ANIMAL)
data class AnimalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val habitat: String,
    val diet: String
)
