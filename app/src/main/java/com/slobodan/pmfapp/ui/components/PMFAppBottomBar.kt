package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R

@Composable
fun PMFAppBottomBar (
    onHomeClick: () -> Unit,
    onInfoClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        IconButton(
            onClick = onHomeClick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(R.string.dsc_pocetna)
            )
        }
        IconButton(
            onClick = onInfoClick,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = stringResource(R.string.dsc_informacije)
            )
        }
    }
}