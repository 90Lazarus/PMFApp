package com.slobodan.pmfapp.data.source

import com.slobodan.pmfapp.data.model.DegreeLevel
import com.slobodan.pmfapp.data.model.Department
import com.slobodan.pmfapp.data.model.StudyPrograms

val availablePrograms: Map<Pair<DegreeLevel, Department>, List<StudyPrograms>> = mapOf(
    //Biologija i ekologija
    (DegreeLevel.BACHELORS to Department.BIO) to
            listOf(StudyPrograms.B_BIO_B),
    (DegreeLevel.MASTERS to Department.BIO) to
            listOf(StudyPrograms.M_BIO_B,
                StudyPrograms.M_BIO_EZP,
                StudyPrograms.M_BIO_MBF),
    (DegreeLevel.DOCTORS to Department.BIO) to
            listOf(StudyPrograms.D_BIO_B),

    //Geografija i turizam
    (DegreeLevel.BACHELORS to Department.GEO) to
            listOf(StudyPrograms.B_GEO_G),
    (DegreeLevel.MASTERS to Department.GEO) to
            listOf(StudyPrograms.M_GEO_G,
                StudyPrograms.M_GEO_T),
    (DegreeLevel.DOCTORS to Department.GEO) to
            listOf(StudyPrograms.D_GEO_G),

    //Matematika
    (DegreeLevel.BACHELORS to Department.MATH) to
            listOf(StudyPrograms.B_MATH_M),
    (DegreeLevel.MASTERS to Department.MATH) to
            listOf(StudyPrograms.M_MATH_OM,
                StudyPrograms.M_MATH_PM,
                StudyPrograms.M_MATH_PM2,
                StudyPrograms.M_MATH_VSFM),
    (DegreeLevel.DOCTORS to Department.MATH) to
            listOf(StudyPrograms.D_MATH_M),

    //Računarske nauke
    (DegreeLevel.BACHELORS to Department.CS) to
            listOf(StudyPrograms.B_CS_RN),
    (DegreeLevel.MASTERS to Department.CS) to
            listOf(StudyPrograms.M_CS_VIMU,
                StudyPrograms.M_CS_RS,
                StudyPrograms.M_CS_UI),
    (DegreeLevel.DOCTORS to Department.CS) to
            listOf(StudyPrograms.D_CS_RN),

    //Fizika
    (DegreeLevel.BACHELORS to Department.PHY) to
            listOf(StudyPrograms.B_PHY_F),
    (DegreeLevel.MASTERS to Department.PHY) to
            listOf(StudyPrograms.M_PHY_EPF,
                StudyPrograms.M_PHY_NF,
                StudyPrograms.M_PHY_TFP),
    (DegreeLevel.DOCTORS to Department.PHY) to
            listOf(StudyPrograms.D_PHY_F),

    //Hemija
    (DegreeLevel.BACHELORS to Department.CHE) to
            listOf(StudyPrograms.B_CHE_H),
    (DegreeLevel.MASTERS to Department.CHE) to
            listOf(StudyPrograms.M_CHE_PH,
                StudyPrograms.M_CHE_I,
                StudyPrograms.M_CHE_PHOM),
    (DegreeLevel.DOCTORS to Department.CHE) to
            listOf(StudyPrograms.D_CHE_H),
)