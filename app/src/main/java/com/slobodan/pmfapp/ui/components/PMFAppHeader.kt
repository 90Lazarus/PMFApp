package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R

@Composable
fun PMFAppHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.pmf_logo),
            contentDescription = stringResource(R.string.faculty_logo_description)
            )
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.university_name),
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(R.string.faculty_name),
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
    Image(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        painter = painterResource(R.drawable.pmf_front),
        contentDescription = stringResource(R.string.faculty_photo),
        contentScale = ContentScale.FillWidth
    )
}