package com.slobodan.pmfapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slobodan.pmfapp.data.model.DegreeLevels
import com.slobodan.pmfapp.data.model.Departments
import com.slobodan.pmfapp.navigation.PMFAppScreens
import com.slobodan.pmfapp.ui.screens.DegreeLevelsScreen
import com.slobodan.pmfapp.ui.screens.DepartmentsScreen
import com.slobodan.pmfapp.ui.screens.StudyProgramsScreen

@Composable
fun PMFApp() {
    val navController = rememberNavController()
    val selectedDegree = remember { mutableStateOf<DegreeLevels?>(null) }
    val selectedDepartment = remember { mutableStateOf<Departments?>(null) }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
                            popUpTo(PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
                                inclusive = true
                            }
                        }
                    },
                    //modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Početna strana", textAlign = TextAlign.Center)
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = PMFAppScreens.DEGREE_LEVELS_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
                DegreeLevelsScreen(
                    onDegreeSelected = { degree ->
                        selectedDegree.value = degree
                        navController.navigate(PMFAppScreens.DEPARTMENTS_SCREEN.name)
                    }
                )
            }
            composable(route = PMFAppScreens.DEPARTMENTS_SCREEN.name) {
                DepartmentsScreen(
                    selectedDegree = selectedDegree.value!!,
                    onDepartmentSelected = { department ->
                        selectedDepartment.value = department
                        navController.navigate(PMFAppScreens.STUDY_PROGRAMS_SCREEN.name)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = PMFAppScreens.STUDY_PROGRAMS_SCREEN.name) {
                StudyProgramsScreen(
                    selectedDegree = selectedDegree.value!!,
                    selectedDepartment = selectedDepartment.value!!,
                    onStudyProgramSelected = { program ->
                        // whatever comes next
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}