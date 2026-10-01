package com.slobodan.pmfapp.data.model.enums

enum class StudyPrograms(val displayName: String, val dbName: String?) {
    //Biologija i ekologija
    B_BIO_B("Biologija", ""),
    M_BIO_B("Biologija", ""),
    M_BIO_EZP("Ekologija i zaštita prirode", ""),
    M_BIO_MBF("Molekularna biologija i fiziologija", ""),
    D_BIO_B("Biologija", ""),

    //Geografija i turizam
    B_GEO_G("Geografija", ""),
    M_GEO_G("Geografija", ""),
    M_GEO_T("Turizam", ""),
    D_GEO_G("Geonauke", ""),

    //Matematika
    B_MATH_M("Matematika", ""),
    M_MATH_OM("Opšta matematika", ""),
    M_MATH_PM("Profesor matematike", ""),
    M_MATH_PM2("Primenjena matematika", ""),
    M_MATH_VSFM("Verovatnoća, statistika i finansijska matematika", ""),
    D_MATH_M("Matematika", ""),

    //Računarske nauke
    B_CS_RN("Računarske nauke", "OAS Računarske nauke"),
    M_CS_VIMU("Veštačka inteligencija i mašinsko učenje", ""),
    M_CS_RS("Razvoj softvera", ""),
    M_CS_UI("Upravljanje informacijama", ""),
    D_CS_RN("Računarske nauke", ""),

    //Fizika
    B_PHY_F("Fizika", ""),
    M_PHY_EPF("Eksperimentalna i primenjena fizika", ""),
    M_PHY_NF("Nastava fizike", ""),
    M_PHY_TFP("Teorijska fizika i primene", ""),
    D_PHY_F("Fizika", ""),

    //Hemija
    B_CHE_H("Hemija", ""),
    M_CHE_PH("Profesor hemije", ""),
    M_CHE_I("Istraživanje", ""),
    M_CHE_PHOM("Primenjena hemija sa osnovama menažmenta", ""),
    D_CHE_H("Hemija", "")
}