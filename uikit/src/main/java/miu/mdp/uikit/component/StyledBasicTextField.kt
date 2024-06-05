package miu.mdp.uikit.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StyledBasicTextField(
    initialText: String,
    onTextChange: (String) -> Unit,
    hintText: String,
    keyboardOptions: KeyboardOptions,
    showPassword: Boolean = false,
) {
    BasicTextField(
        value = initialText,
        onValueChange = onTextChange,
        modifier = Modifier.fillMaxWidth().height(48.dp),
        singleLine = true,
        textStyle = TextStyle(fontSize = 16.sp),
        keyboardOptions = keyboardOptions,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (initialText.isEmpty()) {
                    Text(
                        text = hintText,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun StyledBasicTextFieldPreview() {
    Column {
        StyledBasicTextField(
            initialText = "",
            onTextChange = {},
            hintText = "Email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(
            modifier = Modifier.fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )

        StyledBasicTextField(
            initialText = "Password",
            onTextChange = {},
            hintText = "Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
    }
}
