package miu.mdp.assignment7.animal.ui

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import miu.mdp.assignment7.animal.ui.animaldetails.AnimalScreen
import miu.mdp.assignment7.animal.ui.dashboard.DashboardScreen
import miu.mdp.assignment7.animal.ui.speciesdetails.SpeciesScreen

@Composable
fun NavigationGraph() {
    val controller = rememberNavController()
    NavHost(controller, startDestination = Screen.DASHBOARD) {
        composable(Screen.DASHBOARD) {
            DashboardScreen(controller)
        }
        composable(Screen.ANIMALS) {
            AnimalScreen(controller)
        }
        composable(Screen.SPECIES) {
            SpeciesScreen(controller)
        }
    }
}