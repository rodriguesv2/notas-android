package br.com.rodroid.notas.presentation.atomic.organism

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.rodroid.notas.presentation.ui.theme.Colors
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun NoteCardOrganism(
    title: String,
    content: String,
    modifier: Modifier = Modifier,
    color: Color = Colors.classicYellow
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                content,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    NotasTheme {
        NoteCardOrganism(
            title = "Isso é um título",
            content = LoremIpsum(words = 30).values.joinToString()
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    NotasTheme {
        NoteCardOrganism(
            title = "Isso é um título",
            content = LoremIpsum(words = 30).values.joinToString()
        )
    }
}