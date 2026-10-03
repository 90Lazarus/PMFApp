package com.slobodan.pmfapp

import android.app.LocaleManager
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.slobodan.pmfapp.navigation.PMFApp
import com.slobodan.pmfapp.ui.theme.PMFAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //start in Cyrillic FFS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val localeManager = getSystemService(LocaleManager::class.java)

            if (localeManager.applicationLocales.isEmpty) {
                localeManager.applicationLocales =
                    LocaleList.forLanguageTags("sr-Cyrl")
            }
        }
        enableEdgeToEdge()
        setContent {
            PMFAppTheme {
                PMFApp()
            }
        }
    }
}
