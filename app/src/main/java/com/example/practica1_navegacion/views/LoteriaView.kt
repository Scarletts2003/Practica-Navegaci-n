package com.example.practica1_navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practica1_navegacion.Components.MainIconButton
import com.example.practica1_navegacion.Components.Space
import com.example.practica1_navegacion.Components.TitleBar
import com.example.practica1_navegacion.viewModels.LoteriaViewModels

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LotView(viewModels: LoteriaViewModels, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Loteria") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Magenta
                ),
                navigationIcon = {
                    Row {
                        MainIconButton(icon = Icons.Default.ArrowBack) {
                            navController.popBackStack()
                        }
                        Space()
                        MainIconButton(icon = Icons.Default.ArrowForward) {
                            navController.navigate("Edad")
                        }
                    }
                }
            )
        }
    ) {
        LoteriaView(viewModels ,navController)
    }
}

@Composable
fun LoteriaView(viewModels: LoteriaViewModels, navController: NavController){
    val lottonNumber = viewModels.lotoNumbers.value
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (lottonNumber.isEmpty()){
            Text(text = "Loteria", fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }else{
            LotteryNumbers(lottonNumber)
        }

        Button(colors = ButtonDefaults.buttonColors(
            contentColor = Color.Magenta,
            containerColor = Color.White), onClick = { viewModels.generateLotoNumbers()}) {
            Text(text = "Generar", fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }

}

@Composable
fun LotteryNumbers(lottonNumber: List<Int>) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp)
    )
    {

        items(lottonNumber){ number->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Magenta, CircleShape)

            ){
                Text(text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp)

            }
        }
    }
}