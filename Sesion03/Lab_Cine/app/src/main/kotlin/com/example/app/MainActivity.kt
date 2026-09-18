package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.spacedBy
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Principal()
                }
            }
        }
    }
}

@Composable
fun Principal(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(1) }
    var isCanchita by remember { mutableStateOf(false) }
    var isBebida by remember { mutableStateOf(false) }
    var isCupon by remember { mutableStateOf(false) }

    val precioEntrada = 10
    val precioCanchita = 5
    val precioBebida = 3
    val precioCupon = 2

    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Head()

            Spacer(modifier = Modifier.height(24.dp))

            Entradas(
                count = count,
                onIncrement = { count++ },
                onDecrement = { if (count > 0) count-- }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Extras(
                isCanchita = isCanchita,
                onCanchitaChange = { isCanchita = it },
                isBebida = isBebida,
                onBebidaChange = { isBebida = it }
            )

            Cupon(
                isCupon = isCupon,
                onCuponChange = { isCupon = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Total(
                count = count,
                precioEntrada = precioEntrada,
                isCanchita = isCanchita,
                precioCanchita = precioCanchita,
                isBebida = isBebida,
                precioBebida = precioBebida,
                isCupon = isCupon,
                precioCupon = precioCupon
            )
        }
    }
}

@Composable
fun Head(modifier: Modifier = Modifier) {
    Text(
        text = "Compra de Entradas",
        style = MaterialTheme.typography.h5,
        modifier = modifier
    )
}

@Composable
fun Entradas(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(text = "Cantidad de entradas")
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = onDecrement) {
                Text("-")
            }
            Text(
                text = "$count",
                style = MaterialTheme.typography.subtitle1
            )
            Button(onClick = onIncrement) {
                Text("+")
            }
        }
    }
}

@Composable
fun Check(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = label)
    }
}

@Composable
fun Extras(
    isCanchita: Boolean,
    onCanchitaChange: (Boolean) -> Unit,
    isBebida: Boolean,
    onBebidaChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.Start, modifier = modifier) {
        Text(
            text = "Adicionales:",
            style = MaterialTheme.typography.subtitle1
        )
        Check(
            checked = isCanchita,
            onCheckedChange = onCanchitaChange,
            label = "Canchita ($5)"
        )
        Check(
            checked = isBebida,
            onCheckedChange = onBebidaChange,
            label = "Bebida ($3)"
        )
    }
}

@Composable
fun Cupon(
    isCupon: Boolean,
    onCuponChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Check(
        checked = isCupon,
        onCheckedChange = onCuponChange,
        label = "Cupón de descuento ($2)",
        modifier = modifier
    )
}

@Composable
fun Total(
    count: Int,
    precioEntrada: Int,
    isCanchita: Boolean,
    precioCanchita: Int,
    isBebida: Boolean,
    precioBebida: Int,
    isCupon: Boolean,
    precioCupon: Int,
    modifier: Modifier = Modifier
) {
    val subtotalEntradas = count * precioEntrada
    val subtotalCanchita = if (isCanchita) precioCanchita else 0
    val subtotalBebida = if (isBebida) precioBebida else 0
    val descuento = if (isCupon) precioCupon else 0
    val montoSubTotal = subtotalEntradas + subtotalCanchita + subtotalBebida
    val montoTotal = (montoSubTotal - descuento).coerceAtLeast(0)

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Subtotal: $$montoSubTotal",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Descuento: $$descuento",
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Total a pagar: $$montoTotal",
            style = MaterialTheme.typography.h6
        )
    }
}