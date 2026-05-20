package com.example.colormatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colormatch.screens.GameScreen
import com.example.colormatch.screens.ResultScreen
import com.example.colormatch.screens.WelcomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "welcome"
            ) {

                composable("welcome") {

                    WelcomeScreen(
                        onStartClick = {
                            navController.navigate("game")
                        }
                    )
                }

                composable("game") {

                    GameScreen(
                        onFinishGame = {
                            navController.navigate("result")
                        }
                    )
                }

                composable("result") {

                    ResultScreen(
                        onPlayAgain = {
                            navController.navigate("welcome")
                        }
                    )
                }
            }
        }
    }
}