package com.example.practica1_navegacion.views

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.practica1_navegacion.Components.ActionButton
import com.example.practica1_navegacion.Components.MainButton
import com.example.practica1_navegacion.Components.Space
import com.example.practica1_navegacion.Components.TitleBar
import com.example.practica1_navegacion.Components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) {
       PaginaP(navController)
    }
}

@Composable
fun PaginaP(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home")
        Space()
        MainButton(name = "Descuentos", backColor = Color.Gray, color = Color.White ) {
            navController.navigate("Descuento")
        }
        Space()
        MainButton(name = "Loteria", backColor = Color.LightGray, color = Color.White ) {
            navController.navigate("Loteria")
        }
        Space()
        MainButton(name = "Edad Perruna", backColor = Color.DarkGray, color = Color.White) {
            navController.navigate("Edad")
        }
    }
}