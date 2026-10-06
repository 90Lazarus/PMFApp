package com.slobodan.pmfapp.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Fax
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Pin
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.ui.components.InformationContactItem

@Composable
fun InformationScreen() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        tonalElevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                shape = CutCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = stringResource(R.string.kontakt_i_informacije),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                shape = CutCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(4.dp)
                ) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.AddHome,
                                label = stringResource(R.string.l_adresa_fakulteta),
                                value = stringResource(R.string.inf_full_address),
                                textColour = MaterialTheme.colorScheme.tertiary,
                                onClick = {
                                    val mapUri = "geo:0,0?q=Višegradska 33, Niš".toUri()
                                    val intent = Intent(Intent.ACTION_VIEW, mapUri)
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.Phone,
                                label = stringResource(R.string.inf_telefon_fakulteta),
                                value = "+38118533015",
                                textColour = MaterialTheme.colorScheme.tertiary,
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_DIAL,
                                        "tel:+38118533015".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.Fax,
                                label = stringResource(R.string.inf_fax),
                                value = "(018) 533-014",
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.Pin,
                                label = stringResource(R.string.inf_pib),
                                value = "100668023",
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.AccountBalanceWallet,
                                label = stringResource(R.string.inf_broj_racuna),
                                value = "840-0000032807845-68",
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.Email,
                                label = stringResource(R.string.inf_email),
                                value = "pmfinfo@pmf.ni.ac.rs",
                                textColour = MaterialTheme.colorScheme.tertiary,
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_SENDTO,
                                        "mailto:pmfinfo@pmf.ni.ac.rs".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.Facebook,
                                label = stringResource(R.string.inf_facebook),
                                value = "@Pmf.Nis",
                                textColour = MaterialTheme.colorScheme.tertiary,
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        "https://www.facebook.com/Pmf.Nis".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            shape = CutCornerShape(4.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            InformationContactItem(
                                icon = Icons.Default.CameraAlt,
                                label = stringResource(R.string.inf_instagram),
                                value = "@pmfnis",
                                textColour = MaterialTheme.colorScheme.tertiary,
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        "https://www.instagram.com/pmf.nis/".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}