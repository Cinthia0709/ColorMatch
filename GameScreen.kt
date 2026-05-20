package com.example.colormatch.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colormatch.viewmodel.GameViewModel
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.animation.core.animateFloatAsState

@Composable
fun GameScreen(
    onFinishGame: () -> Unit,
    viewModel: GameViewModel = viewModel()
) {

    val currentColor by viewModel.currentColor.collectAsState()
    val currentName by viewModel.currentName.collectAsState()
    val score by viewModel.score.collectAsState()
    val timeLeft by viewModel.timeLeft.collectAsState()
    val mensaje by viewModel.mensaje.collectAsState()
    val tamañoAnimado by animateFloatAsState(

        targetValue = if (mensaje == "Correcto") 220f else 180f,

        label = ""
    )

    LaunchedEffect(timeLeft) {

        if (timeLeft > 0) {

            delay(1000)
            viewModel.bajarTiempo()

        } else {

            viewModel.guardarPartida()
            onFinishGame()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Puntaje: $score")
        Text("Tiempo: $timeLeft")
        Spacer(
            modifier = Modifier.height(20.dp)
        )

        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(tamañoAnimado.dp)
                .background(currentColor)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(currentName)
        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(mensaje)

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row {

            Button(
                onClick = {
                    viewModel.verificarRespuesta("Rojo")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("Rojo")
            }

            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.size(10.dp)
            )

            Button(
                onClick = {
                    viewModel.verificarRespuesta("Azul")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Azul")
            }
        }

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row {

            Button(
                onClick = {
                    viewModel.verificarRespuesta("Verde")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("Verde")
            }

            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.size(10.dp)
            )

            Button(
                onClick = {
                    viewModel.verificarRespuesta("Amarillo")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow
                )
            ) {
                Text("Amarillo")
            }
        }

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(onClick = onFinishGame) {
            Text("Terminar")
        }
    }
}