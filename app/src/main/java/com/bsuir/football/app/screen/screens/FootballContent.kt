package com.bsuir.football.app.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhotographyContent(){
    Surface(color = MaterialTheme.colors.onSecondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp).clickable{
        },
    ) {
        Column(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(Color.Magenta)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f).padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Welcome to the Football !!!",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
@Preview
fun SpaceXContextPreview() {
    PhotographyContent()
}
