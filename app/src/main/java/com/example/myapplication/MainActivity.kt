package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaComponentes{
                val intent = Intent(this, MainActivityDos::class.java)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun PantallaComponentes(onClick: () -> Unit) {
    Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
    contentAlignment=Alignment.Center)
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("elemento texto")

            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.background(Color.Blue)){
                Row {
                    Text("columna 1")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("columna 2")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Sample Image",
                modifier = Modifier.size(width = 400.dp, height = 100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onClick) {
                Text("Abrir Segunda pestaña")
            }
        }

    }
}
