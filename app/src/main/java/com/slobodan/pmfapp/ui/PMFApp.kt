package com.slobodan.pmfapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.slobodan.pmfapp.data.model.enums.DegreeLevel
import com.slobodan.pmfapp.data.model.enums.Department
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.navigation.PMFAppScreens
import com.slobodan.pmfapp.ui.components.PMFAppBottomBar
import com.slobodan.pmfapp.ui.components.PMFTopAppBar
import com.slobodan.pmfapp.ui.screens.DegreeLevelsScreen
import com.slobodan.pmfapp.ui.screens.DepartmentsScreen
import com.slobodan.pmfapp.ui.screens.ProgramScreen
import com.slobodan.pmfapp.ui.screens.StudyProgramsScreen
import com.slobodan.pmfapp.ui.screens.SubjectScreen
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PMFApp() {
    val navController = rememberNavController()
    //val selectedDegree = remember { mutableStateOf<DegreeLevel?>(null) }
    var selectedDegreeName by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedDegree = selectedDegreeName?.let { DegreeLevel.valueOf(it) }
    //val selectedDepartment = remember { mutableStateOf<Department?>(null) }
    var selectedDepartmentName by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedDepartment = selectedDepartmentName?.let { Department.valueOf(it) }

    val selectedProgram = remember { mutableStateOf<StudyPrograms?>(null) }
    val selectedProgramId = remember { mutableStateOf<Int?>(null) }
    val selectedSubjectId = remember { mutableStateOf<Int?>(null) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            PMFAppBottomBar(
                onClickAction = {
                    navController.navigate(PMFAppScreens.DEGREE_LEVELS_SCREEN.name
                    ) {
                        popUpTo(PMFAppScreens.DEGREE_LEVELS_SCREEN.name
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        },
//        bottomBar = {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Button(
//                    onClick = {
//                        navController.navigate(PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
//                            popUpTo(PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
//                                inclusive = true
//                            }
//                        }
//                    },
//                    //modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(text = "Početna strana", textAlign = TextAlign.Center)
//                }
//            }
//        },
        topBar = {
            PMFTopAppBar (
                showBackButton = currentRoute != PMFAppScreens.DEGREE_LEVELS_SCREEN.name,
                onBackClick = { navController.popBackStack() }
            ) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = PMFAppScreens.DEGREE_LEVELS_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PMFAppScreens.DEGREE_LEVELS_SCREEN.name) {
                DegreeLevelsScreen(
                    onDegreeSelected = { degree ->
                        selectedDegreeName = degree.name
                        navController.navigate(PMFAppScreens.DEPARTMENTS_SCREEN.name)
                    }
                )
            }
            composable(route = PMFAppScreens.DEPARTMENTS_SCREEN.name) {
                DepartmentsScreen(
                    selectedDegree = selectedDegree!!,
                    onDepartmentSelected = { department ->
                        selectedDepartmentName = department.name
                        navController.navigate(PMFAppScreens.STUDY_PROGRAMS_SCREEN.name)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = PMFAppScreens.STUDY_PROGRAMS_SCREEN.name) {
                StudyProgramsScreen(
                    selectedDegree = selectedDegree!!,
                    selectedDepartment = selectedDepartment!!,
                    onStudyProgramSelected = { program ->
                        selectedProgram.value = program
                        navController.navigate(PMFAppScreens.PROGRAM_SCREEN.name)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = PMFAppScreens.PROGRAM_SCREEN.name) {
                ProgramScreen(
                    selectedProgram = selectedProgram.value!!,
                    onSubjectSelected = { subjectId ->
                        selectedSubjectId.value = subjectId
                        navController.navigate(PMFAppScreens.SUBJECT_SCREEN.name)
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = PMFAppScreens.SUBJECT_SCREEN.name) {
                SubjectScreen(
                    subjectId = selectedSubjectId.value!!,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}