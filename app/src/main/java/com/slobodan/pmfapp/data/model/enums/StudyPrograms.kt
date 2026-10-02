package com.slobodan.pmfapp.data.model.enums

import androidx.annotation.StringRes
import com.slobodan.pmfapp.R

enum class StudyPrograms(@param:StringRes val displayName: Int, val dbName: String?) {
    //Biologija i ekologija
    B_BIO_B(R.string.b_bio_b, ""),
    M_BIO_B(R.string.m_bio_b, ""),
    M_BIO_EZP(R.string.m_bio_ezp, ""),
    M_BIO_MBF(R.string.m_bio_mbf, ""),
    D_BIO_B(R.string.d_bio_b, ""),

    //Geografija i turizam
    B_GEO_G(R.string.b_geo_g, ""),
    M_GEO_G(R.string.m_geo_g, ""),
    M_GEO_T(R.string.m_geo_t, ""),
    D_GEO_G(R.string.d_geo_g, ""),

    //Matematika
    B_MATH_M(R.string.b_math_m, ""),
    M_MATH_OM(R.string.b_math_om, ""),
    M_MATH_PM(R.string.m_math_pm, ""),
    M_MATH_PM2(R.string.m_math_pm2, ""),
    M_MATH_VSFM(R.string.m_math_vsfm, ""),
    D_MATH_M(R.string.d_math_m, ""),

    //Računarske nauke
    B_CS_RN(R.string.b_cs_rn, "ОАС Рачунарске науке"),
    M_CS_VIMU(R.string.m_cs_vimu, ""),
    M_CS_RS(R.string.m_cs_rs, ""),
    M_CS_UI(R.string.m_cs_ui, ""),
    D_CS_RN(R.string.d_cd_rn, ""),

    //Fizika
    B_PHY_F(R.string.b_phy_f, ""),
    M_PHY_EPF(R.string.m_phy_epf, ""),
    M_PHY_NF(R.string.m_phy_nf, ""),
    M_PHY_TFP(R.string.m_phy_tfp, ""),
    D_PHY_F(R.string.d_phy_f, ""),

    //Hemija
    B_CHE_H(R.string.b_che_h, ""),
    M_CHE_PH(R.string.m_che_ph, ""),
    M_CHE_I(R.string.m_che_i, ""),
    M_CHE_PHOM(R.string.m_che_phom, ""),
    D_CHE_H(R.string.d_che_h, "")
}