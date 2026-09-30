package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.DegreeLevel
import com.slobodan.pmfapp.data.model.Department

@Composable
fun RowScope.DegreeCard(
    name: String,
    selected: Boolean
) {
    Card(
        modifier = Modifier.weight(1f).padding(6.dp),
        shape = CutCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected)
                    MaterialTheme.colorScheme.primaryContainer
                else
                    MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Text(
            text = name,
            modifier = Modifier.fillMaxWidth().padding(6.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DepartmentsScreen(
    selectedDegree: DegreeLevel,
    onDepartmentSelected: (Department) -> Unit,
    onBackClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        tonalElevation = 4.dp,
        //border = BorderStroke(width = 1.dp, color = Color.Magenta)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.padding(6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.pmf_logo),
                    contentDescription = "University logo"
                )
                Text(text = "Prirodno-matematički fakultet u Nišu", textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineSmall)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Image(
                painter = painterResource(R.drawable.pmf_front),
                contentDescription = "University photo"
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DegreeCard(
                    name = "OAS",
                    selected = selectedDegree == DegreeLevel.BACHELORS
                )
                DegreeCard(
                    name = "MAS",
                    selected = selectedDegree == DegreeLevel.MASTERS
                )
                DegreeCard(
                    name = "DAS",
                    selected = selectedDegree == DegreeLevel.DOCTORS
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Column(
                modifier = Modifier.fillMaxSize().padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.padding(6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                    Text(text="Odaberite departman:", style = MaterialTheme.typography.titleMedium)
                }

                Button(
                    onClick = { onDepartmentSelected(Department.BIO) },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(text = Department.BIO.displayName) }
                )

                Button(
                    onClick = { onDepartmentSelected(Department.GEO) },
                    modifier = Modifier.fillMaxWidth(),
                    content ={ Text(text = Department.GEO.displayName) }
                )

                Button(
                    onClick = { onDepartmentSelected(Department.MATH) },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(text = Department.MATH.displayName) }
                )

                Button(
                    onClick = { onDepartmentSelected(Department.CS) },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(text = Department.CS.displayName) }
                )

                Button(
                    onClick = { onDepartmentSelected(Department.PHY) },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(text = Department.PHY.displayName) }
                )

                Button(
                    onClick = { onDepartmentSelected(Department.CHE) },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(text = Department.CHE.displayName) }
                )
            }
        }
    }
}