package miu.mdp.assignment7.animal.ui.speciesdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import miu.mdp.assignment7.R
import miu.mdp.assignment7.animal.data.Result
import miu.mdp.assignment7.animal.model.Species
import miu.mdp.assignment7.animal.ui.addspecies.AddSpeciesScreen
import miu.mdp.core.showToast
import miu.mdp.uikit.component.FabButton
import miu.mdp.uikit.component.TopActionBar
import miu.mdp.uikit.theme.PurpleAmethyst

@Composable
fun SpeciesScreen(controller: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    val viewModel: SpeciesViewModel = hiltViewModel()
    val result = viewModel.fetchResult.observeAsState().value
    Scaffold(
        topBar = {
            TopActionBar(
                title = stringResource(R.string.k_species_details),
                containerColor = PurpleAmethyst,
                iconClick = { controller.navigateUp() }
            )
        },
        content = {
            SpeciesList(
                result = result,
                onAddClick = { showDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(it)
            )
            if (showDialog) {
                AddSpeciesScreen(
                    onCancel = { showDialog = false },
                    onSave = { name, description ->
                        viewModel.insertSpecies(Species(name, description))
                        showDialog = false
                    },
                    onDismissRequest = { showDialog = false }
                )
            }
        }
    )
}

@Composable
fun SpeciesList(
    result: Result<List<Species>>?,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    ConstraintLayout(modifier = modifier) {
        val (recyclerView, addButton) = createRefs()
        when (result) {
            is Result.Error -> context.showToast("Error: ${result.throwable.message}")
            is Result.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .constrainAs(recyclerView) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        }
                ) {
                    items(result.data) {
                        SpeciesItem(it)
                    }
                }
            }

            else -> {}
        }

        FabButton(
            onClick = { onAddClick() },
            modifier = Modifier.constrainAs(addButton) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            },
        )
    }
}

@Composable
fun SpeciesItem(species: Species) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = species.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = species.description,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun SpeciesContentPreview() {
    val species = listOf(
        Species(name = "Species", description = "Description"),
        Species(name = "Species", description = "Description")
    )
    Scaffold(
        topBar = {
            TopActionBar(
                title = stringResource(R.string.k_species_details),
                containerColor = PurpleAmethyst
            )
        },
        content = {
            SpeciesList(
                result = Result.Success(species),
                onAddClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(it)
            )
        }
    )
}
