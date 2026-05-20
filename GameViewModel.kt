package com.example.colormatch.viewmodel

import android.app.Application
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs =
        application.getSharedPreferences("game_data", Context.MODE_PRIVATE)

    private val colores = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow
    )

    private val nombres = listOf(
        "Rojo",
        "Azul",
        "Verde",
        "Amarillo"
    )

    private val _currentColor = MutableStateFlow(Color.Red)
    val currentColor = _currentColor.asStateFlow()

    private val _currentName = MutableStateFlow("Rojo")
    val currentName = _currentName.asStateFlow()

    private val _score = MutableStateFlow(0)
    val score = _score.asStateFlow()

    private val _timeLeft = MutableStateFlow(30)
    val timeLeft = _timeLeft.asStateFlow()

    private val _mensaje = MutableStateFlow("")
    val mensaje = _mensaje.asStateFlow()

    private val _highScore =
        MutableStateFlow(prefs.getInt("high_score", 0))

    val highScore = _highScore.asStateFlow()

    private val _historial = MutableStateFlow(listOf<Int>())
    val historial = _historial.asStateFlow()

    init {
        cambiarColor()
    }

    fun cambiarColor() {

        val index = (0 until colores.size).random()

        _currentColor.value = colores[index]
        _currentName.value = nombres[index]
    }

    fun verificarRespuesta(color: String) {

        if (color == _currentName.value) {

            _score.value++

            actualizarHighScore()

            _mensaje.value = "Correcto"

            cambiarColor()

        } else {

            _mensaje.value = "Incorrecto"
        }
    }

    fun bajarTiempo() {

        if (_timeLeft.value > 0) {

            _timeLeft.value--
        }
    }

    fun actualizarHighScore() {

        if (_score.value > _highScore.value) {

            _highScore.value = _score.value

            prefs.edit()
                .putInt("high_score", _score.value)
                .apply()
        }
    }

    fun guardarPartida() {

        _historial.value = _historial.value + _score.value
    }

    fun reiniciarJuego() {

        _score.value = 0
        _timeLeft.value = 30
        _mensaje.value = ""

        cambiarColor()
    }
}