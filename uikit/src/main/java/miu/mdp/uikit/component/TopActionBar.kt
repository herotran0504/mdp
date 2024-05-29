package miu.mdp.uikit.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopActionBar(
    title: String,
    titleColor: Color = Color.White,
    containerColor: Color,
    iconTintColor: Color = Color.White,
    imageVector: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    iconClick: () -> Unit = {},
    navigationIcon: @Composable () -> Unit = {
        IconButton(
            onClick = { iconClick() }) {
            Icon(
                imageVector = imageVector,
                tint = iconTintColor,
                contentDescription = "Back"
            )
        }
    }
) {
    TopAppBar(
        title = { Text(text = title, color = titleColor) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = containerColor),
        navigationIcon = navigationIcon
    )
}