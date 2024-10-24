package com.example.practica1_navegacion.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practica1_navegacion.views.ContentHomeView

@Composable
fun DosTarjetas(titulo1: String, numero1:String, titulo2: String, numero2: String){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        MainCard(titulo = titulo1, numero = numero1,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f)
        )
        SpaceW(10.dp)

        MainCard(titulo = titulo2, numero = numero2,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f))

    }
}

@Composable
fun MainCard(titulo: String, numero: String, modifier: Modifier = Modifier){

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(text = titulo, color = Color.Black, fontSize = 20.sp)
            Text(text = "$$numero", color = Color.Black, fontSize = 20.sp)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App descuento", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }){
        ContentHomeView(it, navController)
    }
}