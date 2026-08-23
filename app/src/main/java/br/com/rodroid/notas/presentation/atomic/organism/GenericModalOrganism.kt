package br.com.rodroid.notas.presentation.atomic.organism

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import br.com.rodroid.notas.R
import br.com.rodroid.notas.presentation.ui.theme.Colors
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme

@Composable
fun GenericModalOrganism(
    title: String,
    subtitle: String,
    onMainButtonClick: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    mainButtonText: String = stringResource(R.string.modal_default_main_button),
    secondaryButtonText: String = stringResource(R.string.modal_default_secondary_button),
    onSecondaryButtonClick: (() -> Unit)? = null,
    icon: Painter = painterResource(R.drawable.ic_info),
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties()
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    modifier = Modifier.size(60.dp),
                    painter = icon,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    title,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(subtitle)
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    if (onSecondaryButtonClick != null) {
                        ModalButtonMolecule(
                            modifier = Modifier.weight(1f),
                            label = secondaryButtonText,
                            onClick = onSecondaryButtonClick,
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    ModalButtonMolecule(
                        modifier = Modifier.weight(1f),
                        label = mainButtonText,
                        onClick = onMainButtonClick,
                    )
                }
            }
        }
    }
}

@Composable
private fun ModalButtonMolecule(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.classicYellow,
            contentColor = Color.Black,
        )
    ) {
        Text(label)
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
private fun Preview() {
    PreviewDefault()
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)

@Composable
private fun PreviewLight() {
    PreviewDefault()
}

@Composable
private fun PreviewDefault(modifier: Modifier = Modifier) {
    NotasTheme {
        GenericModalOrganism(
            title = "Excluir",
            subtitle = "Tem certeza que deseja excluir essa nota?",
            onMainButtonClick = {},
            onSecondaryButtonClick = {},
            onDismissRequest = {},
            modifier = modifier
        )
    }
}