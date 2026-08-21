package br.com.rodroid.notas.presentation.atomic.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodroid.notas.R
import br.com.rodroid.notas.presentation.ui.theme.Colors
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun ColorMolecule(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(color)
            .clickable(onClick = onClick)
    ) {
        if (isSelected)
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(R.drawable.ic_cicle_check_mark),
                contentDescription = "",
                tint = Colors.solidBlue
            )
    }
}

@Preview
@Composable
private fun Preview() {
    NotasTheme {
        ColorMolecule(
            modifier = Modifier
                .height(100.dp)
                .width(80.dp),
            color = Colors.coralPink,
            isSelected = true,
            onClick = {}
        )
    }
}