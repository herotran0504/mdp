package miu.mdp.uikit.component

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import miu.mdp.util.parseColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledCheckBox(
    initValue: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        Checkbox(
            checked = initValue,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.parseColor("#EFD48F"),
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White,
                disabledCheckedColor = Color.LightGray,
                disabledUncheckedColor = Color.DarkGray,
                disabledIndeterminateColor = Color.LightGray
            )
        )
    }
}
