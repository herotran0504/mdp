package miu.mdp.extra.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import miu.mdp.extra.data.PROGRAMS
import miu.mdp.extra.model.Program

@Composable
fun MainScreen(viewModel: ProgramViewModel = hiltViewModel()) {
    val programs by viewModel.programs.observeAsState(emptyList())
    ProgramsScreen(programs)
}

@Composable
fun ProgramsScreen(programs: List<Program>) {
    LazyColumn {
        items(programs) { ProgramCard(it) }
    }
}

@Composable
fun ProgramCard(program: Program) {
    val painter = rememberAsyncImagePainter(
        imageRequest(LocalContext.current, program)
    )
    Column(modifier = Modifier.background(Color.LightGray)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = program.name,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.background(Color.Transparent)
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
        var isExpanded by rememberSaveable { mutableStateOf(false) }
        Text(
            text = program.description,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded }
                .padding(8.dp)

        )
    }
}

@Composable
private fun imageRequest(context: Context, program: Program) = ImageRequest.Builder(context)
    .data(data = program.cover)
    .apply(block = fun ImageRequest.Builder.() {
        listener(
            onStart = {
                Log.d("ImageLoader", "Image request started")
            },
            onSuccess = { _, _ ->
                Log.d("ImageLoader", "Image request successful")
            },
            onError = { _, result ->
                Log.e("ImageLoader", "Image request failed ${result.throwable.message}")
            }
        )
    })
    .build()

@Preview(showBackground = true)
@Composable
private fun ProgramCardPreview() {
    ProgramCard(PROGRAMS.last())
}
