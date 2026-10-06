package com.slobodan.pmfapp.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.slobodan.pmfapp.data.model.enums.DegreeLevel
import com.slobodan.pmfapp.data.model.enums.Department
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.ui.components.PMFAppBottomBar
import com.slobodan.pmfapp.ui.components.PMFTopAppBar
import com.slobodan.pmfapp.ui.screens.DegreeLevelsScreen
import com.slobodan.pmfapp.ui.screens.DepartmentsScreen
import com.slobodan.pmfapp.ui.screens.InformationScreen
import com.slobodan.pmfapp.ui.screens.ProgramScreen
import com.slobodan.pmfapp.ui.screens.StudyProgramsScreen
import com.slobodan.pmfapp.ui.screens.SubjectScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PMFApp() {
    var selectedDegreeName by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedDegree =
//        if (selectedDegreeName != null) {
//            DegreeLevel.valueOf(selectedDegreeName)
//        } else {
//            null
//        }
        selectedDegreeName?.let { DegreeLevel.valueOf(it) }
    var selectedDepartmentName by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedDepartment = selectedDepartmentName?.let { Department.valueOf(it) }
    var selectedProgramName by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedProgram = selectedProgramName?.let { StudyPrograms.valueOf(it) }
    var selectedSubjectId by rememberSaveable { mutableStateOf<Int?>(null) }

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val handleBack: () -> Unit = {
        if (currentRoute == PMFAppScreens.SUBJECT_SCREEN.name) {
            navController.popBackStack(
                PMFAppScreens.PROGRAM_SCREEN.name,
                inclusive = false
            )
        } else {
            navController.popBackStack()
        }
    }
    BackHandler(
        enabled = currentRoute != PMFAppScreens.DEGREE_LEVELS_SCREEN.name,
        onBack = handleBack
    )
    Scaffold(
        bottomBar = {
            PMFAppBottomBar(
                onHomeClick = {
                    navController.navigate(
                        route = PMFAppScreens.DEGREE_LEVELS_SCREEN.name
                    ) {
                        popUpTo(
                            route = PMFAppScreens.DEGREE_LEVELS_SCREEN.name
                        ) { inclusive = true }
                    }
                },
                onInfoClick = {
                    navController.navigate(route = PMFAppScreens.INFORMATION_SCREEN.name)
                }
            )
        },
        topBar = {
            PMFTopAppBar (
                showBackButton = currentRoute != PMFAppScreens.DEGREE_LEVELS_SCREEN.name,
                onBackClick = handleBack
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
                    }
                )
            }
            composable(route = PMFAppScreens.STUDY_PROGRAMS_SCREEN.name) {
                StudyProgramsScreen(
                    selectedDegree = selectedDegree!!,
                    selectedDepartment = selectedDepartment!!,
                    onStudyProgramSelected = { program ->
                        selectedProgramName = program.name
                        navController.navigate(PMFAppScreens.PROGRAM_SCREEN.name)
                    }
                )
            }
            composable(route = PMFAppScreens.PROGRAM_SCREEN.name) {
                if (selectedProgram != null) {
                    ProgramScreen(
                        selectedProgram = selectedProgram,
                        onSubjectSelected = { subjectId ->
                            selectedSubjectId = subjectId
                            navController.navigate(PMFAppScreens.SUBJECT_SCREEN.name)
                        }
                    )
                }
            }
            composable(route = PMFAppScreens.SUBJECT_SCREEN.name) {
                selectedSubjectId?.let {
                    SubjectScreen(
                        subjectId = it,
                        onSubjectSelected = { subjectId ->
                            selectedSubjectId = subjectId
                            navController.navigate(PMFAppScreens.SUBJECT_SCREEN.name)
                        }
                    )
                }
            }
            composable(route = PMFAppScreens.INFORMATION_SCREEN.name) {
                InformationScreen()
            }
        }
    }
}