package com.slobodan.pmfapp.ui.components

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Surface
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.core.os.LocaleListCompat
import android.os.Build
import android.app.LocaleManager
import android.os.LocaleList
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PMFTopAppBar(
    showBackButton: Boolean,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    fun setAppLanguage(languageTag: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val localeManager = context.getSystemService(LocaleManager::class.java)

            localeManager.applicationLocales =
                LocaleList.forLanguageTags(languageTag)
        }
    }
    var languageMenuExpanded by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = { Text("PMF") },
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        actions = {
//            TextButton( onClick = { setAppLanguage("en") }
//            ) { Text("EN") }
//            TextButton( onClick = { setAppLanguage("sr-Latn") }
//            ) { Text("RS-Lat") }
//            TextButton( onClick = { setAppLanguage("sr-Cyrl") }
//            ) { Text("RS-Cyr") }

            Box {
                IconButton(
                    onClick = { languageMenuExpanded = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = "Jezik"
                    )
                }

                DropdownMenu(
                    expanded = languageMenuExpanded,
                    onDismissRequest = { languageMenuExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("English") },
                        onClick = {
                            languageMenuExpanded = false
                            setAppLanguage("en")
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Srpski - latinica") },
                        onClick = {
                            languageMenuExpanded = false
                            setAppLanguage("sr-Latn")
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Српски - ћирилица") },
                        onClick = {
                            languageMenuExpanded = false
                            setAppLanguage("sr-Cyrl")
                        }
                    )
                }
            }

            IconButton(
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        "https://www.pmf.ni.ac.rs/".toUri()
                    )
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.OpenInBrowser,
                    contentDescription = "Sajt fakulteta"
                )
            }
        }
    )
}
//    androidx.compose.material3.Surface(
//        shadowElevation = 4.dp
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth().statusBarsPadding()
//                .padding(2.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (showBackButton) {
//                IconButton(
//                    onClick = onBackClick
//                ) {
//                Icon(
//                    Icons.AutoMirrored.Filled.ArrowBack,
//                    contentDescription = "Back"
//                )
//            }
//
//            Text(
//                text = "PMF Niš",
//                modifier = Modifier.weight(1f),
//                textAlign = TextAlign.Center
//            )
//        }
//    }
