package com.slobodan.pmfapp

import android.app.LocaleManager
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.slobodan.pmfapp.data.database.PMFAppDatabase
import com.slobodan.pmfapp.ui.PMFApp
import com.slobodan.pmfapp.ui.theme.PMFAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setApplicationLocales(
//            AppCompatDelegate.getApplicationLocales()
//        )
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
            }
            PMFApp()
        }
//        lifecycleScope.launch {
//            val db = PMFAppDatabase.getDatabase(this@MainActivity)
//
//            val subjects = db.subjectDao().getSubjectsLowDetails(1)
//            subjects.forEach {
//                Log.d("DATABASE_TEST", "${it.code} | ${it.name} | ${it.semester} | ${it.espb}")
//            }
//
//            val studyPrograms = db.studyProgramDao().getStudyProgramsWithDetails(1, 4)
//            studyPrograms.forEach {
//                Log.d("DATABASE_TEST", "${it.studyProgram.name} | ${it.degreeLevel.name} | ${it.department.name}")
//            }
//        }
    }
}
