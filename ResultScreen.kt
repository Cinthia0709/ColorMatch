package com.example.colormatch.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colormatch.viewmodel.GameViewModel

@Composable
fun ResultScreen(
    onPlayAgain: () -> Unit,
    viewModel: GameViewModel = viewModel()
) {

    val score by viewModel.score.collectAsState()
    val highScore by viewModel.highScore.collectAsState()
    val historial by viewModel.historial.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Puntaje final: $score")

        Text("Mejor puntaje: $highScore")

        Text("Historial")

        LazyColumn {

            items(historial) { puntos ->

                Text("Partida: $puntos")
            }
        }

        Button(
            onClick = {

                viewModel.reiniciarJuego()
                onPlayAgain()
            }
        ) {

            Text("Jugar otra vez")
        }
    }
}