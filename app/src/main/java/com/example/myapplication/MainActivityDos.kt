package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityDos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaVerde {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    @Composable
    fun PantallaVerde(onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            contentAlignment = Alignment.Center
        )
        {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Otros componentes")

                Spacer(modifier = Modifier.height(16.dp))

                var texto by remember { mutableStateOf("") }
                TextField(
                    value = texto,
                    onValueChange = { texto = it },
                    label = { Text("Introduce texto") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                var outlinedTexto by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = outlinedTexto,
                    onValueChange = { outlinedTexto = it },
                    label = { Text("Outlined Texto") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    var isChecked by remember { mutableStateOf(false)}
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                    )
                    Text("Check me")
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    var isSwitched by remember { mutableStateOf(false)}
                    Switch(
                        checked = isSwitched,
                        onCheckedChange = { isSwitched = it }
                    )
                    Text("Switch")
                }

                Spacer(modifier = Modifier.height(16.dp))

                var valorSlider = remember { mutableStateOf(0f) }
                Text("Valor del slider: ${valorSlider.value.toInt()}")
                Slider(
                    value = valorSlider.value,
                    onValueChange = { valorSlider.value = it },
                    valueRange = 0f..100f
                )

                Spacer(modifier = Modifier.height(16.dp))

                val opciones =  listOf("Opcion 1", "Opcion 2")
                val seleccion = remember { mutableStateOf("Option 1") }
                Text("Elegi una opcion:")
                Row {
                    opciones.forEach { opcion ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (opcion == seleccion.value),
                                onClick = { seleccion.value = opcion }
                            )
                            Text(opcion)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}