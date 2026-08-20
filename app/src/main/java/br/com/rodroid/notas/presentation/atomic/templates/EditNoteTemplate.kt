package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodroid.notas.domain.entities.NoteColor
import br.com.rodroid.notas.presentation.atomic.molecules.ColorMolecule
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun EditNoteTemplate(
    colors: List<NoteColor>
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                colors.forEach { color ->
                    ColorMolecule(
                        Color(color.colorHex),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    NotasTheme(dynamicColor = false) {
        EditNoteTemplate(NoteColor.entries)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    NotasTheme(dynamicColor = false) {
        EditNoteTemplate(NoteColor.entries)
    }
}