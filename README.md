# Color Match 🎨

Aplicación desarrollada en Kotlin utilizando Jetpack Compose y arquitectura MVVM.  
El juego consiste en identificar correctamente el color mostrado antes de que termine el tiempo.

---

# Tecnologías utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Navigation Compose
- MVVM
- StateFlow
- SharedPreferences
- Material 3

---

# Funcionalidades implementadas

## Pantalla de bienvenida
- Título del juego.
- Mensaje explicativo.
- Botón para iniciar partida.

## Pantalla de juego
- Colores aleatorios.
- Botones interactivos de colores.
- Temporizador de 30 segundos.
- Puntaje en tiempo real.
- Cambio automático de color.
- Feedback:
  - Correcto
  - Incorrecto
- Cuadrado visual dinámico del color actual.
- Navegación automática al finalizar el tiempo.

## Pantalla de resultados
- Puntaje final.
- Mejor puntaje histórico.
- Historial de partidas.
- Botón para volver a jugar.
- Uso de LazyColumn.

---

# Arquitectura implementada

Se utilizó arquitectura MVVM:

- `GameViewModel`
- Separación entre lógica y UI
- Uso de `MutableStateFlow`
- Uso de `collectAsState`

---

# Funcionalidades técnicas implementadas

- Navigation Compose
- Corrutinas
- LaunchedEffect
- Temporizador dinámico
- Manejo de estados
- SharedPreferences
- LazyColumn
- Animaciones con Compose
- Componentes Material 3

---

# Persistencia

Se utilizó `SharedPreferences` para guardar el mejor puntaje incluso después de cerrar la aplicación.

---

# Animaciones

Se implementaron animaciones utilizando:
- `animateFloatAsState`

---

# Organización del proyecto

```text
screens/
- WelcomeScreen.kt
- GameScreen.kt
- ResultScreen.kt

viewmodel/
- GameViewModel.kt
