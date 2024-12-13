package com.example.electricidad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.electricidad.ui.theme.ElectricidadTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }

    }
}


data class Mensaje(val mensaje : String) //Data class para nuevas funciones

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() { //Scaffold
    var presses by remember { mutableIntStateOf(0) } //Para botón flotante, sacado de internet y para futiras pruebas.

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Cálculos Eléctricos de Resistencias")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Barra Inferior",
                )
            }
        },
        floatingActionButton = { // Botón flotante al pulsar incrementa de uno en uno, pero no pasa el resultado.
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column( // Ponemos los datos en columnas.
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = " Programa Electricidad - Electrotécnia.", //Texto inicial
                modifier = Modifier.padding(8.dp), textAlign = TextAlign.Center,

               /* """
                    You have pressed the floating action button $presses times.
                """.trimIndent(),*/
            )
            val items = listOf(" Aluminio", " Cobre", " Estaño", " Grafito", " Plata") //List con los datos de distintos tipos de materiales eléctricos
            TarjetaElevada("Resistencia cable según Longitud/Sección") // Texto de las tarjetas.
            ItemList(items) // Mostramos la lista de materiales.
            TarjetaElevada("Potencia y energía eléctrica")
            TarjetaElevada("Efecto térmico")
            TarjetaElevada("Circuitos serie - paralelo")
            TarjetaElevada("Generadores electroquimicos y forovoltaicos")
            TarjetaElevada("Condensadores")
            }
    }
}

@Composable
fun TarjetaElevada(name : String) {// Para las tarjetas donde podremos los eventos futuros
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 480.dp, height = 60.dp)
    ) {
        Row (modifier = Modifier.padding(all =8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.electrico),// Imagen sacada de internet y que se pasa a las tarjetas.
            contentDescription = "Foto Electricidad",
            modifier = Modifier
                .size(42.dp)
        )
        Text(
            text = "$name",
            modifier = Modifier
                .padding(4.dp),
            textAlign = TextAlign.Center,
        )
        }
    }
}

@Composable // Lista requerida.
fun ItemList(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun ElectricidadPreview() {
    Scaffold()

}
