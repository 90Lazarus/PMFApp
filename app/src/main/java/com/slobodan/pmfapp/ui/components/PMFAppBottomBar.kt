package com.slobodan.pmfapp.ui.components

import android.service.autofill.OnClickAction
import android.view.Surface
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.data.model.DegreeLevel

@Composable
fun PMFAppBottomBar (
    onClickAction: () -> Unit
) {
//    NavigationBar(
//        modifier = Modifier.height(56.dp)
//    ) {
//        IconButton(onClick = onClickAction) {
//            Icon(Icons.Default.Home, "Početna")
//        }
//    }
//    NavigationBar(
//        //modifier = Modifier.height(54.dp)
//    ) {
//        NavigationBarItem(
//            selected = false,
//            onClick = {
//                onClickAction()
//            },
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = "Početna"
//                )
//            },
//            label = {
//                Text("Početna", style = MaterialTheme.typography.labelSmall)
//            }
//        )
//    }
    //Surface(
    //    tonalElevation = 4.dp
    //) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = onClickAction
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Početna"
                )
            }

        }
}