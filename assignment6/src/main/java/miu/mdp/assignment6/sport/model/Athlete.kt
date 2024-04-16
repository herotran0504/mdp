package miu.mdp.assignment6.sport.model

data class Athlete(
    val name: String,
    val sport: String,
    val country: String,
    val bestPerformance: String,
    val medals: Int,
    val facts: String
)