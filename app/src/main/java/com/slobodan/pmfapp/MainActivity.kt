package com.slobodan.pmfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.slobodan.pmfapp.ui.PMFApp
import com.slobodan.pmfapp.ui.theme.PMFAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMFAppTheme {
            }
            PMFApp()
        }
    }
}
