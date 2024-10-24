package com.example.practica1_navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practica1_navegacion.Components.MainButton
import com.example.practica1_navegacion.Components.MainIconButton
import com.example.practica1_navegacion.Components.Space
import com.example.practica1_navegacion.Components.TitleBar
import com.example.practica1_navegacion.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EdadView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Edad Perruna") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    Row {
                        MainIconButton(icon = Icons.Default.ArrowBack) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }
    ) {
        Vista(navController)
    }
}

@Composable
fun Vista(navController: NavController){
    PosicionP(titulo = "Calculadora de edad perruna", imagen = painterResource(id = R.drawable.el_origen_de_bluey))
}


@Composable
fun PosicionP(titulo:String, imagen: Painter, modifier: Modifier = Modifier){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = modifier
            .padding(16.dp)
            .wrapContentSize(Alignment.Center),
    ) {
        Spacer(modifier = modifier.padding(20.dp))
        var edad by remember { mutableStateOf("") }
        var resultado by remember {
            mutableStateOf("")
        }
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = titulo,
            color = Color.Blue,
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = edad,
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Ingresa tú edad") },
            onValueChange = {
                edad = it
            }
        )


        OutlinedTextField(
            value = resultado,
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Edad perruna") },
            onValueChange = {
                resultado = it
            }

        )

        ElevatedButton(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.White),
            onClick = {
                var res = 0
                res = edad.toInt() * 7
                resultado = res.toString()
            } ){
            Text(text = "Calcular")
        }

    }
}