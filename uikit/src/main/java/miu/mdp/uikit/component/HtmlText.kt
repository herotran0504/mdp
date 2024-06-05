package miu.mdp.uikit.component

import android.view.Gravity
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
@ReadOnlyComposable
fun textResource(@StringRes id: Int): CharSequence = LocalContext.current.resources.getText(id)

@Composable
fun HtmlText(
    text: CharSequence,
    modifier: Modifier = Modifier,
    gravity: Int = Gravity.CENTER
) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context).also { it.gravity = gravity } },
        update = { it.text = text }
    )
}
