\# 🎬 Cine - Compra de Entradas



\## 📋 Información del Informe



\* \*\*Curso:\*\* Introducción al Desarrollo de Nuevas Plataformas\[cite: 1]

\* \*\*Práctica:\*\* Informe 03 - Laboratorio Cine\[cite: 1]

\* \*\*Docente:\*\* Ing. Ernesto Mauro Suarez Lopez\[cite: 1]

\* \*\*Sección:\*\* "A"\[cite: 1]

\* \*\*Fecha:\*\* 18 de septiembre del 2026\[cite: 1]

\* \*\*Lugar:\*\* Arequipa, Perú\[cite: 1]



\### 👥 Integrantes

\* Choque Dongo Gonzalo Joel\[cite: 1]

\* Forocca Mamani Maxs Sebastian Joaquin\[cite: 1]

\* Quispe Saavedra Dennis Javier\[cite: 1]

\* Salas Aguilar Juan victor\[cite: 1]



\---



\## 📱 Descripción del Proyecto



Aplicación móvil desarrollada en \*\*Android\*\* con \*\*Jetpack Compose\*\* y \*\*Material Design 3\*\*, orientada a la simulación interactiva de compra de entradas de cine y productos adicionales de confitería\[cite: 1].



\---



\## 💡 Aspectos Clave de Implementación



\### 1. State Hoisting (Elevación de Estado)

Centralización de las variables reactivas en la pantalla principal para distribuirlas a los componentes hijos\[cite: 1]:



```kotlin

// Elevación de estado en Principal.kt

var count by remember { mutableStateOf(1) }

var isCanchita by remember { mutableStateOf(false) }

var isBebida by remember { mutableStateOf(false) }

var isCupon by remember { mutableStateOf(false) }



val precioEntrada = 10

val precioCanchita = 5

val precioBebida = 3

val precioCupon = 2

```



\### 2. Lógica de Cálculo Reactivo

Determinación en tiempo real del subtotal, descuentos y precio total a pagar:



```kotlin

// Cálculo dinámico en el composable Total

val subtotalEntradas = count \* precioEntrada

val subtotalCanchita = if (isCanchita) precioCanchita else 0

val subtotalBebida = if (isBebida) precioBebida else 0

val descuento = if (isCupon) precioCupon else 0



val montoSubTotal = subtotalEntradas + subtotalCanchita + subtotalBebida

val montoTotal = montoSubTotal - descuento

```



\---



\## 📂 Estructura del Módulo `app`



\* `MainActivity.kt`: Inicialización y configuración del contenedor Compose\[cite: 1].

\* `ui/screens/Principal.kt`: Pantalla principal, elevación de estado y composables (`Entradas`, `Extras`, `Cupon`, `Total`)\[cite: 1].

