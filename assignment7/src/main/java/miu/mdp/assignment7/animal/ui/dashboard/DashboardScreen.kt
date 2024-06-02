package miu.mdp.assignment7.animal.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import miu.mdp.assignment7.R
import miu.mdp.assignment7.animal.ui.Screen
import miu.mdp.uikit.component.TopActionBar
import miu.mdp.uikit.theme.PurpleAmethyst

@Composable
fun DashboardScreen(controller: NavHostController) {
    DashboardContent(animalDetails = {
        controller.navigate(Screen.ANIMALS)
    }, speciesDetails = {
        controller.navigate(Screen.SPECIES)
    })
}

@Composable
fun DashboardContent(animalDetails: () -> Unit = {}, speciesDetails: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopActionBar(
                title = stringResource(R.string.k_title_home),
                containerColor = PurpleAmethyst,
                navigationIcon = {}
            )
        },
        content = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .padding(it),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { animalDetails() }) {
                        Text(text = stringResource(R.string.k_animal_details))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { speciesDetails() }) {
                        Text(text = stringResource(R.string.k_species_details))
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DashboardContentPreview() {
    DashboardContent()
}
