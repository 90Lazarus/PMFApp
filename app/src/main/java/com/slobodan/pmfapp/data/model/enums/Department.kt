package com.slobodan.pmfapp.data.model.enums

import androidx.annotation.StringRes
import com.slobodan.pmfapp.R

enum class Department(@param:StringRes val displayName: Int) {
    BIO(R.string.biologija_i_ekologija),
    GEO(R.string.geografija_i_turizam),
    MATH(R.string.matematika),
    CS(R.string.racunarske_nauke),
    PHY(R.string.fizika),
    CHE(R.string.hemija)
}