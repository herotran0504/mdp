package miu.mdp.assignment4.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miu.mdp.assignment4.R
import miu.mdp.assignment4.widget.PrimaryButtonBackground
import miu.mdp.assignment4.widget.SecondaryButtonBackground
import miu.mdp.uikit.component.StyledBasicTextField
import miu.mdp.uikit.component.StyledCheckBox

@Composable
fun SignInScreen(
    onSignIn: (String, String) -> Unit,
    onCreateAccount: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_amz_com_logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = stringResource(id = R.string.e_sign_in),
            fontSize = 32.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = MaterialTheme.shapes.extraSmall
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFEBEAEB),
                    shape = MaterialTheme.shapes.extraSmall
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StyledBasicTextField(
                initialText = email,
                onTextChange = { email = it },
                hintText = stringResource(id = R.string.e_email),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            HorizontalDivider(color = Color(0xFFEBEAEB))
            StyledBasicTextField(
                initialText = password,
                onTextChange = { password = it },
                hintText = stringResource(id = R.string.e_password),
                showPassword = showPassword,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            StyledCheckBox(
                initValue = showPassword,
                onCheckedChange = { showPassword = it },
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(id = R.string.e_show_password),
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp)
                .clickable { onSignIn(email, password) }
        ) {
            PrimaryButtonBackground {
                Text(
                    text = stringResource(id = R.string.e_sign_in),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(color = Color(0xFFE5E5E5))
            Text(
                text = stringResource(id = R.string.e_new_to_amazon),
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 8.dp),
                color = Color.Gray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clickable(onClick = onCreateAccount)
        ) {
            SecondaryButtonBackground {
                Text(
                    text = stringResource(id = R.string.e_create_a_new_amazon_account),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
    ) {
        SignInScreen({ _, _ -> }, {})
    }
}
