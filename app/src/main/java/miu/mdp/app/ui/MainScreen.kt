package miu.mdp.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miu.mdp.app.nav.Nav
import miu.mdp.uikit.R

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(Nav())
}

@Composable
fun MainScreen(nav: Nav) {
    MaterialTheme {
        Box {
            Image(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Main Screen",
                painter = painterResource(R.drawable.bg)
            )
            MainContent(nav)
        }
    }
}

@Composable
fun MainContent(nav: Nav) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            PrimaryButton(
                text = stringResource(miu.mdp.R.string.app_assignment2),
                modifier = Modifier.fillMaxWidth(),
                onClick = { nav.openAssignment2(context) }
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                PrimaryButton(
                    text = stringResource(miu.mdp.R.string.app_assignment3_1),
                    modifier = Modifier.weight(1f),
                    onClick = { nav.openAssignment31(context) }
                )
                PrimaryButton(
                    text = stringResource(miu.mdp.R.string.app_assignment3_2),
                    modifier = Modifier.weight(1f),
                    onClick = { nav.openAssignment32(context) }
                )
            }
            PrimaryButton(
                text = stringResource(miu.mdp.R.string.app_assignment4),
                modifier = Modifier.fillMaxWidth(),
                onClick = { nav.openAssignment4(context) }
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                PrimaryButton(
                    text = stringResource(miu.mdp.R.string.app_assignment5_1),
                    modifier = Modifier.weight(1f),
                    onClick = { nav.openAssignment51(context) }
                )
                PrimaryButton(
                    text = stringResource(miu.mdp.R.string.app_assignment5_2),
                    modifier = Modifier.weight(1f),
                    onClick = { nav.openAssignment52(context) }
                )
            }
            PrimaryButton(
                text = stringResource(miu.mdp.R.string.app_assignment6),
                modifier = Modifier.fillMaxWidth(),
                onClick = { nav.openAssignment6(context) }
            )
            PrimaryButton(
                text = stringResource(miu.mdp.R.string.app_assignment7),
                modifier = Modifier.fillMaxWidth(),
                onClick = { nav.openAssignment7(context) }
            )
            PrimaryButton(
                text = stringResource(miu.mdp.R.string.app_extra),
                modifier = Modifier.fillMaxWidth(),
                onClick = { nav.openExtra(context) }
            )
        }
    }
}
