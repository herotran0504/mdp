package miu.mdp.assignment3.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miu.mdp.assignment3.R

@Composable
fun AmzToolbar() {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFEFEFEF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_amazon_logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xFFE5E5E5))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AmzToolbarPreview() {
    AmzToolbar()
}
