package com.example.practica1_navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practica1_navegacion.Components.BotonReutilizable
import com.example.practica1_navegacion.Components.DosTarjetas
import com.example.practica1_navegacion.Components.MainIconButton
import com.example.practica1_navegacion.Components.Space
import com.example.practica1_navegacion.Components.SpaceH
import com.example.practica1_navegacion.Components.TextFields
import com.example.practica1_navegacion.Components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DescuentoView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Descuento") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    Row {
                        MainIconButton(icon = Icons.Default.ArrowBack) {
                            navController.popBackStack()
                        }
                        Space()
                        MainIconButton(icon = Icons.Default.ArrowForward) {
                            navController.navigate("Loteria")
                        }
                    }
                }
            )
        }
    ) {
        ContentHomeView(it, navController)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }

        DosTarjetas(titulo1 = "Total",
            numero1 = precioTotal,
            titulo2 = "Descuento",
            numero2 = precioDescuento)

        TextFields(value = precio ,
            onValueChange = {precio = it},
            label = "Precio")
        TextFields(value = descuento,
            onValueChange = {descuento = it} ,
            label = "Descuento")
        SpaceH(10.dp)

        BotonReutilizable(text = "Calcular") {
            if(precio != ""){
                precioDescuento = (precio.toDouble() * (descuento.toDouble()/100)).toString()
                precioTotal = (precio.toDouble() - precioDescuento.toDouble()).toString()
            }else{

            }
        }
        SpaceH(10.dp)

        BotonReutilizable(text = "Limpiar") {
            precioDescuento = "0.0"
            precioTotal = "0.0"
            precio = ""
            descuento = ""
        }




    }


}