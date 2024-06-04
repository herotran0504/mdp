package miu.mdp.assignment3.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miu.mdp.util.parseColor

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.parseColor("#EFD48F")
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(
                width = 1.dp,
                color = Color.parseColor("#C2C2C2"),
                shape = RoundedCornerShape(4.dp)
            ),
        contentPadding = PaddingValues(4.dp),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryButton(text = "Primary", onClick = {})
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(text = "Secondary", onClick = {}, containerColor = Color.White)
    }
}
