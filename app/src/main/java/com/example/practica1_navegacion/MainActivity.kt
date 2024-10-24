package com.example.practica1_navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica1_navegacion.navigation.NavManager
import com.example.practica1_navegacion.ui.theme.Practica1_NavegacionTheme
import com.example.practica1_navegacion.viewModels.LoteriaViewModels
import com.example.practica1_navegacion.views.Home
import com.example.practica1_navegacion.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoteriaViewModels by viewModels()
        enableEdgeToEdge()
        setContent {
            Practica1_NavegacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    NavManager(viewModel)
                }
            }
        }
    }
}
