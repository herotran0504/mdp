package miu.mdp.assignment2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miu.mdp.assignment2.R

@Composable
fun ChemicalScreen(viewModel: ChemicalViewModel) {
    val message = viewModel.message.observeAsState().value ?: stringResource(R.string.chemical_title)
    ChemicalScreenContent(
        message = message,
        onGuessChange = { viewModel.guessChemical(it) },
        onAddChemicalChange = { viewModel.addChemical(it) }
    )
}

@Composable
fun ChemicalScreenContent(
    message: String = stringResource(R.string.chemical_title),
    onGuessChange: (String) -> Unit,
    onAddChemicalChange: (String) -> Unit
) {
    var guessChemicalValue by remember { mutableStateOf("") }
    var addChemicalValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Text(text = message, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = guessChemicalValue,
            onValueChange = { guessChemicalValue = it },
            label = { Text(text = stringResource(R.string.chemical_guess_subtitle)) },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { onGuessChange(guessChemicalValue) }) {
            Text(text = stringResource(R.string.chemical_guess_btn))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = addChemicalValue,
            onValueChange = { addChemicalValue = it },
            label = { Text(text = stringResource(R.string.chemical_add_subtitle)) },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { onAddChemicalChange(addChemicalValue) }) {
            Text(text = stringResource(R.string.chemical_add_btn))
        }

        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.chemical),
            contentDescription = "",
            modifier = Modifier.size(240.dp).align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChemicalScreenPreview() {
    ChemicalScreenContent(
        onGuessChange = {},
        onAddChemicalChange = {}
    )
}
