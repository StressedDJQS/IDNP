\# 🎬 Lab Cine - Compra de Entradas

<p align="center">

&#x20; <strong>UNIVERSIDAD NACIONAL DE SAN AGUSTÍN DE AREQUIPA</strong><br>

&#x20; Facultad de Ingeniería de Producción y Servicios<br>

&#x20; Escuela Profesional de Ingeniería Electrónica<br>

&#x20; <em>Introducción al Desarrollo de Nuevas Plataformas</em>

</p>



\---



\## 📋 Información General



\* \*\*Curso:\*\* Introducción al Desarrollo de Nuevas Plataformas

\* \*\*Práctica:\*\* Informe 03 - Laboratorio Cine

\* \*\*Docente:\*\* Ing. Ernesto Mauro Suarez Lopez

\* \*\*Sección:\*\* "A"

\* \*\*Fecha:\*\* 18 de septiembre del 2026

\* \*\*Lugar:\*\* Arequipa, Perú



\### 👥 Integrantes

\* Choque Dongo, Gonzalo Joel

\* Forocca Mamani, Maxs Sebastian Joaquin

\* Quispe Saavedra, Dennis Javier

\* Salas Aguilar, Juan Victor



\---



\## 📱 Descripción del Proyecto



Aplicación móvil desarrollada en \*\*Android\*\* con \*\*Jetpack Compose\*\* y \*\*Material Design 3\*\*, orientada al cálculo dinámico de costos para la compra de entradas de cine y productos de confitería.



\### Conceptos Clave Implementados:

\* \*\*State Hoisting (Elevación de estado):\*\* Manejo centralizado del estado (`count`, `isCanchita`, `isBebida`, `isCupon`) en el composable principal para garantizar un flujo unidireccional de datos y componentes reutilizables.

\* \*\*Componentes Compose:\*\* Modificadores, `Scaffold`, `Row`, `Column`, `Checkbox`, `Button`, y `Text`.

\* \*\*Cálculo reactivo:\*\* Actualización instantánea del subtotal, descuentos y precio final.



\---



\## 📸 Captura de Pantalla



<p align="center">

&#x20;  <img src="screenshots/app\_preview.png" alt="Renderizado de interfaz" width="280"/>

</p>



\---



\## 💻 Estructura del Código Fuente



\### 1. `MainActivity.kt`

Punto de entrada de la aplicación que inicializa el tema y llama a la vista principal:



```kotlin

package com.example.compras



import android.os.Bundle

import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent

import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier

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

&#x20;                   Principal()

&#x20;               }

&#x20;           }

&#x20;       }

&#x20;   }

}

