package com.example.practica1_navegacion.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practica1_navegacion.Components.HomeView
import com.example.practica1_navegacion.viewModels.LoteriaViewModels
import com.example.practica1_navegacion.views.Contador
import com.example.practica1_navegacion.views.DescuentoView
import com.example.practica1_navegacion.views.EdadView
import com.example.practica1_navegacion.views.Home
import com.example.practica1_navegacion.views.LotView
import com.example.practica1_navegacion.views.LoteriaView
import com.example.practica1_navegacion.views.Vista


@Composable
fun NavManager(viewModels: LoteriaViewModels){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            Home(navController)
        }
        composable("Descuento"){
            DescuentoView(navController)
        }
        composable("Loteria"){
            LotView(viewModels , navController)
        }
        composable("Edad"){
            EdadView(navController)
        }

    }
}