package com.slobodan.pmfapp.data.model.enums

import androidx.annotation.StringRes
import com.slobodan.pmfapp.R

enum class DegreeLevel(@param:StringRes val displayName: Int) {
    BACHELORS(R.string.osnovne_akademske_studije),
    MASTERS(R.string.master_akademske_studije),
    DOCTORS(R.string.doktorske_akademske_studije)
}