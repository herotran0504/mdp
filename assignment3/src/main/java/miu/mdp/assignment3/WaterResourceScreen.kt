package miu.mdp.assignment3

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast

@Composable
fun WaterResourceScreen() {
    val context = LocalContext.current
    var resName by remember { mutableStateOf(TextFieldValue()) }
    var resLocation by remember { mutableStateOf(TextFieldValue()) }
    var resType by remember { mutableStateOf(TextFieldValue()) }
    var waterResources by remember { mutableStateOf(listOf<WaterResource>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = resName,
            onValueChange = { resName = it },
            label = { Text(text = stringResource(R.string.res_name)) },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )

        OutlinedTextField(
            value = resLocation,
            onValueChange = { resLocation = it },
            label = { Text(text = stringResource(R.string.res_location)) },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )

        OutlinedTextField(
            value = resType,
            onValueChange = { resType = it },
            label = { Text(text = stringResource(R.string.res_type)) },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )

        Button(
            onClick = {
                if (validateWaterResource(context, resName.text, resLocation.text, resType.text)) {
                    waterResources = waterResources + WaterResource(resName.text, resLocation.text, resType.text)
                    resName = TextFieldValue("")
                    resLocation = TextFieldValue("")
                    resType = TextFieldValue("")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
        ) {
            Text(text = stringResource(R.string.res_add_btn))
        }

        WaterResources(waterResources)
    }
}

@Composable
fun WaterResources(waterResources: List<WaterResource>) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ) {
        WaterResourceItem(
            name = stringResource(R.string.res_name),
            location = stringResource(R.string.res_location),
            type = stringResource(R.string.res_type),
            modifier = Modifier.background(Color(0xFFBB86FC))
        )
        LazyColumn(
            modifier = Modifier.background(Color.LightGray)
        ) {
            items(waterResources) {
                WaterResourceItem(
                    name = it.resName,
                    location = it.resLocation,
                    type = it.resType,
                )
            }
        }
    }
}

@Composable
fun WaterResourceItem(
    name: String,
    location: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(8.dp)) {
        Text(text = name, modifier = Modifier.weight(1f))
        Text(text = location, modifier = Modifier.weight(1f))
        Text(text = type, modifier = Modifier.weight(1f))
    }
}

fun validateWaterResource(context: Context, resName: String, resLocation: String, resType: String): Boolean = when {
    resName.isEmpty() -> {
        displayResRequired(context, context.getString(R.string.res_name_error))
        false
    }

    resLocation.isEmpty() -> {
        displayResRequired(context, context.getString(R.string.res_location_error))
        false
    }

    resType.isEmpty() -> {
        displayResRequired(context, context.getString(R.string.res_type_error))
        false
    }

    else -> true
}

fun displayResRequired(context: Context, message: String) {
    context.showToast(message)
    (context as Activity).hideKeyboard()
}

@Preview(showBackground = true)
@Composable
private fun WaterResourceScreenPreview() {
    WaterResourceScreen()
}

@Preview(showBackground = true)
@Composable
fun WaterResourcesPreview() {
    WaterResources(
        listOf(
            WaterResource(
                resName = "Water Resource Name",
                resLocation = "Resource Location",
                resType = "Resource Type"
            )
        )
    )
}
