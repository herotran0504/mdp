package miu.mdp.assignment3.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AmazonLoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        AmzToolbar()
        AmzContent()
    }
}

@Preview(showBackground = true)
@Composable
fun AmazonLoginScreenPreview() {
    AmazonLoginScreen()
}
