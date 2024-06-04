package miu.mdp.assignment3.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miu.mdp.assignment3.R
import miu.mdp.assignment3.widget.PrimaryButton
import miu.mdp.uikit.component.HtmlText
import miu.mdp.uikit.component.StyledBasicTextField
import miu.mdp.uikit.component.StyledCheckBox
import miu.mdp.uikit.component.textResource
import miu.mdp.util.parseColor

@Composable
fun AmzContent() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(true) }
    var keepSignIn by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HtmlText(
            text = textResource(R.string.sign_in_to_zappos_com_using_your_amazon_account),
            modifier = Modifier.padding(start = 64.dp, end = 64.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.amz_sign_in),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.clickable { },
                text = stringResource(id = R.string.amz_forgot_password_link),
                color = Color(0xFF6D94CD)
            )
        }
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
                hintText = stringResource(id = R.string.amz_login_email),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            HorizontalDivider(color = Color(0xFFEBEAEB))

            StyledBasicTextField(
                initialText = password,
                onTextChange = { password = it },
                hintText = stringResource(id = R.string.amz_login_password),
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
                text = stringResource(id = R.string.amz_show_password),
                modifier = Modifier.padding(start = 6.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            StyledCheckBox(
                initValue = keepSignIn,
                onCheckedChange = { keepSignIn = it },
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(id = R.string.amz_keep_me_sign_in),
                modifier = Modifier.padding(start = 6.dp)
            )
            Text(
                text = stringResource(id = R.string.amz_details),
                modifier = Modifier.padding(start = 6.dp).clickable { },
                color = Color.parseColor("#6D94CD")
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryButton(
            text = stringResource(R.string.amz_sign_in_btn),
            onClick = {}
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(color = Color(0xFFE5E5E5))
            Text(
                text = stringResource(id = R.string.amz_new_to_amazon),
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 8.dp),
                color = Color.Gray
            )
        }
        PrimaryButton(
            text = stringResource(R.string.amz_create_new_amazon_account),
            onClick = {},
            containerColor = Color.White
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFE5E5E5))
        )
        Text(
            modifier = Modifier.fillMaxWidth().clickable { },
            text = stringResource(R.string.amz_conditions_of_use_privacy_notice),
            color = Color.parseColor("#7296c9"),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.amz_copyright),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AmzContentPreview() {
    AmzContent()
}
