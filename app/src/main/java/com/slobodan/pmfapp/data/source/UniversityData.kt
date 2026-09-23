package com.slobodan.pmfapp.data.source

import com.slobodan.pmfapp.data.model.DegreeLevels
import com.slobodan.pmfapp.data.model.Departments
import com.slobodan.pmfapp.data.model.StudyPrograms

val availablePrograms: Map<Pair<DegreeLevels, Departments>, List<StudyPrograms>> = mapOf(
    //Biologija i ekologija
    (DegreeLevels.BACHELORS to Departments.BIO) to
            listOf(StudyPrograms.B_BIO_B),
    (DegreeLevels.MASTERS to Departments.BIO) to
            listOf(StudyPrograms.M_BIO_B,
                StudyPrograms.M_BIO_EZP,
                StudyPrograms.M_BIO_MBF),
    (DegreeLevels.DOCTORS to Departments.BIO) to
            listOf(StudyPrograms.D_BIO_B),

    //Geografija i turizam
    (DegreeLevels.BACHELORS to Departments.GEO) to
            listOf(StudyPrograms.B_GEO_G),
    (DegreeLevels.MASTERS to Departments.GEO) to
            listOf(StudyPrograms.M_GEO_G,
                StudyPrograms.M_GEO_T),
    (DegreeLevels.DOCTORS to Departments.GEO) to
            listOf(StudyPrograms.D_GEO_G),

    //Matematika
    (DegreeLevels.BACHELORS to Departments.MATH) to
            listOf(StudyPrograms.B_MATH_M),
    (DegreeLevels.MASTERS to Departments.MATH) to
            listOf(StudyPrograms.M_MATH_OM,
                StudyPrograms.M_MATH_PM,
                StudyPrograms.M_MATH_PM2,
                StudyPrograms.M_MATH_VSFM),
    (DegreeLevels.DOCTORS to Departments.MATH) to
            listOf(StudyPrograms.D_MATH_M),

    //Računarske nauke
    (DegreeLevels.BACHELORS to Departments.CS) to
            listOf(StudyPrograms.B_CS_RN),
    (DegreeLevels.MASTERS to Departments.CS) to
            listOf(StudyPrograms.M_CS_VIMU,
                StudyPrograms.M_CS_RS,
                StudyPrograms.M_CS_UI),
    (DegreeLevels.DOCTORS to Departments.CS) to
            listOf(StudyPrograms.D_CS_RN),

    //Fizika
    (DegreeLevels.BACHELORS to Departments.PHY) to
            listOf(StudyPrograms.B_PHY_F),
    (DegreeLevels.MASTERS to Departments.PHY) to
            listOf(StudyPrograms.M_PHY_EPF,
                StudyPrograms.M_PHY_NF,
                StudyPrograms.M_PHY_TFP),
    (DegreeLevels.DOCTORS to Departments.PHY) to
            listOf(StudyPrograms.D_PHY_F),

    //Hemija
    (DegreeLevels.BACHELORS to Departments.CHE) to
            listOf(StudyPrograms.B_CHE_H),
    (DegreeLevels.MASTERS to Departments.CHE) to
            listOf(StudyPrograms.M_CHE_PH,
                StudyPrograms.M_CHE_I,
                StudyPrograms.M_CHE_PHOM),
    (DegreeLevels.DOCTORS to Departments.CHE) to
            listOf(StudyPrograms.D_CHE_H),
)