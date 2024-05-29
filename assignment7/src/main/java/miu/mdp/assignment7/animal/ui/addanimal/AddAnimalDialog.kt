package miu.mdp.assignment7.animal.ui.addanimal

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import miu.mdp.assignment7.R
import miu.mdp.core.isValid

@Composable
fun AddAnimalScreen(
    onSave: (String, String, String) -> Unit,
    onCancel: () -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var habitat by remember { mutableStateOf("") }
    var diet by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(2.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.k_add_animal),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = stringResource(R.string.k_animal_name)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = habitat,
                    onValueChange = { habitat = it },
                    label = { Text(text = stringResource(R.string.k_habitat)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = diet,
                    onValueChange = { diet = it },
                    label = { Text(text = stringResource(R.string.k_diet)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onCancel) {
                        Text(text = stringResource(R.string.k_cancel))
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    TextButton(onClick = {
                        context.isValid(name, habitat, diet) {
                            onSave(name, habitat, diet)
                        }
                    }) {
                        Text(text = stringResource(R.string.k_save))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddSpeciesScreen() {
    AddAnimalScreen(onSave = { _, _, _ -> })
}
