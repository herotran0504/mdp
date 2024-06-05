package miu.mdp.assignment4.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButtonBackground(content: @Composable () -> Unit) {
    ButtonBackground(Color(0xFFEFD48F), content)
}

@Composable
private fun ButtonBackground(color: Color, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = color,
                shape = RoundedCornerShape(1.dp)
            )
            .border(
                BorderStroke(1.dp, Color(0xFFC2C2C2)),
                shape = RoundedCornerShape(1.dp)
            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun SecondaryButtonBackground(content: @Composable () -> Unit) {
    ButtonBackground(Color(0xFFF1F1F5), content)
}

@Preview
@Composable
private fun PrimaryButtonBackgroundPreview() {
    PrimaryButtonBackground {}
}

@Preview
@Composable
private fun SecondaryButtonBackgroundPreview() {
    SecondaryButtonBackground {}
}

