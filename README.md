\# 🎬 Lab Cine - Compra de Entradas





<p align="center">

&#x20; <strong>UNIVERSIDAD NACIONAL DE SAN AGUSTÍN DE AREQUIPA</strong><br>

&#x20; Facultad de Ingeniería de Producción y Servicios<br>

&#x20; Escuela Profesional de Ingeniería Electrónica<br>

&#x20; <em>Introducción al Desarrollo de Nuevas Plataformas</em>

</p>



\---



\## 📋 Información del Informe



\* \*\*Curso:\*\* Introducción al Desarrollo de Nuevas Plataformas

\* \*\*Práctica:\*\* Informe 03 - Laboratorio Cine

\* \*\*Docente:\*\* Ing. Ernesto Mauro Suarez Lopez

\* \*\*Sección:\*\* "A"

\* \*\*Fecha:\*\* 18 de septiembre del 2026

\* \*\*Lugar:\*\* Arequipa, Perú



\### 👥 Integrantes

\* Choque Dongo Gonzalo Joel

\* Forocca Mamani Maxs Sebastian Joaquin

\* Quispe Saavedra Dennis Javier

\* Salas Aguilar Juan victor



\---



\## 📱 Descripción del Proyecto



Aplicación móvil desarrollada en \*\*Android\*\* con \*\*Jetpack Compose\*\* y \*\*Material Design 3\*\*, orientada a la simulación interactiva de compra de entradas de cine y productos de confitería.



\### Conceptos Clave Implementados:

\* \*\*State Hoisting (Elevación de Estado):\*\* Manejo centralizado del estado (`count`, `isCanchita`, `isBebida`, `isCupon`) en el composable raíz `Principal` para mantener componentes limpios y reutilizables.

\* \*\*Componentes Compose:\*\* Uso de `Scaffold`, `Column`, `Row`, `Button`, `Checkbox`, `Text` y `Spacer`.

\* \*\*Cálculo reactivo:\*\* Actualización instantánea del subtotal de entradas/adicionales, descuento por cupón y el monto final a pagar.



\---





\## 💻 Código Fuente



\### 1. `MainActivity.kt`



```kotlin

package com.example.compras



import android.os.Bundle

import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent

import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import com.example.compras.ui.screens.Principal

import com.example.compras.ui.theme.ComprasTheme



class MainActivity : ComponentActivity() {

&#x20;   override fun onCreate(savedInstanceState: Bundle?) {

&#x20;       super.onCreate(savedInstanceState)

&#x20;       enableEdgeToEdge()

&#x20;       setContent {

&#x20;           ComprasTheme {

&#x20;               Surface(

&#x20;                   modifier = Modifier.fillMaxSize(),

&#x20;                   color = MaterialTheme.colorScheme.background

&#x20;               ) {

&#x20;                   // Llamamos a la pantalla principal

&#x20;                   Principal()

&#x20;               }

&#x20;           }

&#x20;       }

&#x20;   }

}



@Composable

fun Greeting(name: String, modifier: Modifier = Modifier) {

&#x20;   Text(

&#x20;       text = "Hello $name!",

&#x20;       modifier = modifier

&#x20;   )

}



@Preview(showBackground = true)

@Composable

fun GreetingPreview() {

&#x20;   ComprasTheme {

&#x20;       Greeting("Android")

&#x20;   }

}

```



\---



\### 2. `Principal.kt` (Screen)



```kotlin

package com.example.compras.ui.screens



import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button

import androidx.compose.material3.Checkbox

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp



@Composable

fun Principal(modifier: Modifier = Modifier) {

&#x20;   // Elevación de estado (State Hoisting) para compartir entre composables

&#x20;   var count by remember { mutableStateOf(1) }

&#x20;   var isCanchita by remember { mutableStateOf(false) }

&#x20;   var isBebida by remember { mutableStateOf(false) }

&#x20;   var isCupon by remember { mutableStateOf(false) }



&#x20;   val precioEntrada = 10

&#x20;   val precioCanchita = 5

&#x20;   val precioBebida = 3

&#x20;   val precioCupon = 2



&#x20;   Scaffold(modifier = modifier) { paddingValues ->

&#x20;       Column(

&#x20;           modifier = Modifier

&#x20;               .fillMaxSize()

&#x20;               .padding(paddingValues)

&#x20;               .padding(16.dp),

&#x20;           horizontalAlignment = Alignment.CenterHorizontally,

&#x20;           verticalArrangement = Arrangement.Center

&#x20;       ) {

&#x20;           Head()

&#x20;           Spacer(modifier = Modifier.height(24.dp))

&#x20;           Entradas(

&#x20;               count = count,

&#x20;               onIncrement = { count++ },

&#x20;               onDecrement = { if (count > 0) count-- }

&#x20;           )

&#x20;           Spacer(modifier = Modifier.height(16.dp))

&#x20;           Extras(

&#x20;               isCanchita = isCanchita,

&#x20;               onCanchitaChange = { isCanchita = it },

&#x20;               isBebida = isBebida,

&#x20;               onBebidaChange = { isBebida = it }

&#x20;           )

&#x20;           Cupon(

&#x20;               isCupon = isCupon,

&#x20;               onCuponChange = { isCupon = it }

&#x20;           )

&#x20;           Spacer(modifier = Modifier.height(24.dp))

&#x20;           Total(

&#x20;               count = count,

&#x20;               precioEntrada = precioEntrada,

&#x20;               isCanchita = isCanchita,

&#x20;               precioCanchita = precioCanchita,

&#x20;               is

