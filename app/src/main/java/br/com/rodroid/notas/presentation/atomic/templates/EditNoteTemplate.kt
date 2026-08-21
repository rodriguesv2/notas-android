package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodroid.notas.R
import br.com.rodroid.notas.domain.entities.NoteColor
import br.com.rodroid.notas.presentation.atomic.molecules.ColorMolecule
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun EditNoteTemplate(
    colors: List<NoteColor>,
    colorSelected: Long,
    onColorClick: (NoteColor) -> Unit,
    titleValue: String?,
    onTitleChange: (String) -> Unit,
    contentValue: String?,
    onContentChanged: (String) -> Unit,
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                colors.forEach { color ->
                    ColorMolecule(
                        Color(color.colorHex),
                        modifier = Modifier.weight(1f),
                        onClick = { onColorClick(color) },
                        isSelected = color.colorHex == colorSelected
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(colorSelected)),
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = titleValue ?: "",
                    maxLines = 2,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.edit_note_title_hint),
                            fontSize = 24.sp,
                            color = Color.Black.copy(alpha = .35f),
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    textStyle = TextStyle
                        .Default
                        .copy(
                            fontSize = 24.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        ),
                    onValueChange = onTitleChange,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                    )
                )
                TextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = contentValue ?: "",
                    singleLine = false,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.edit_note_content_hint),
                            color = Color.Black.copy(alpha = .35f),
                            fontSize = 18.sp
                        )
                    },
                    textStyle = TextStyle
                        .Default
                        .copy(
                            color = Color.Black,
                            fontSize = 18.sp,
                        ),
                    onValueChange = onContentChanged,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                    )
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    PreviewDefault()
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    PreviewDefault()
}

@Composable
private fun PreviewDefault() {
    var colorSelected by remember { mutableStateOf(NoteColor.CLASSIC_YELLOW) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    NotasTheme(dynamicColor = false) {
        EditNoteTemplate(
            colors = NoteColor.entries,
            colorSelected = colorSelected.colorHex,
            onColorClick = { item -> colorSelected = item },
            titleValue = title,
            onTitleChange = { value -> title = value },
            contentValue = content,
            onContentChanged = { value -> content = value }
        )
    }
}