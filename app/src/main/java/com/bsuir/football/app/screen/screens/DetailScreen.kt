package com.bsuir.football.app.screen.screens

import android.util.Xml.Encoding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.football.app.model.Endpoint

@Composable
fun DetailScreen(
    endpoint: Endpoint
){
    Surface(
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ){
        Column(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp),
                ) {
                    Text(text = "League ID: ${endpoint.league.id}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "League: ${endpoint.league.name}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Type: ${endpoint.league.type}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Country: ${endpoint.country.name}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Season years: ${endpoint.seasons[0].year}",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)

                }
            }
        }
    }
}