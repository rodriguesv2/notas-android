package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun HomeTemplate() {

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    NotasTheme {
        HomeTemplate()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    NotasTheme {
        HomeTemplate()
    }
}