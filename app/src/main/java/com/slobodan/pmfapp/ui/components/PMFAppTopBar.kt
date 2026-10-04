package com.slobodan.pmfapp.ui.components

import android.app.LocaleManager
import android.content.Intent
import android.os.Build
import android.os.LocaleList
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.slobodan.pmfapp.R

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
        title = @Composable {
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.pmf_logo),
                    contentDescription = stringResource(R.string.dsc_pmf_logo),
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = stringResource(R.string.name_short))
            }
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.dsc_back)
                    )
                }
            }
        },
        actions = {
            Box {
                IconButton(
                    onClick = { languageMenuExpanded = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = stringResource(R.string.dsc_jezik)
                    )
                }
                DropdownMenu(
                    expanded = languageMenuExpanded,
                    onDismissRequest = { languageMenuExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.lng_english)) },
                        onClick = {
                            languageMenuExpanded = false
                            setAppLanguage("en")
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.lng_latin)) },
                        onClick = {
                            languageMenuExpanded = false
                            setAppLanguage("sr-Latn")
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.lng_cyrilic)) },
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
                    contentDescription = stringResource(R.string.dsc_sajt_fakulteta)
                )
            }
        }
    )
}
