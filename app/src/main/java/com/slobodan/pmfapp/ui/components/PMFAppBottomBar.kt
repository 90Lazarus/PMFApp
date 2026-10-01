package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
        Box(
            modifier = Modifier.fillMaxWidth().padding(2.dp),
            //horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = onClickAction,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Početna"
                )
            }
            IconButton(
                onClick = onClickAction,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Informacije"
                )
            }

        }
}