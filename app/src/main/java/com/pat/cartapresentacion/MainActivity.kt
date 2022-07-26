package com.pat.cartapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.pat.cartapresentacion.ui.theme.CartaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CrearCarta()
                }
            }
        }
    }
}

@Composable
fun CrearCarta(){
    val estadoBoton = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White){
            
            Column(modifier = Modifier.height(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                CrearImagenPerfil()
                Divider(thickness = 2.dp)
                MostrarDatosPersonales()
                Button(
                    onClick = {
                        estadoBoton.value = !estadoBoton.value //asigna el valor opuesto al actual

                    }) {
                    Text(text = "Portafolio",
                    style = MaterialTheme.typography.button)
                }
                if(estadoBoton.value){
                    Contenido()
                }else{
                    Box() {
                        
                    }
                }
            }
            
        }

    }
}


@Composable
fun Contenido(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portafolio(datos = listOf<String>("Proyecto 1","Proyecto 2",
                "Proyecto 3","Proyecto 4","Proyecto 5","Proyecto 6"))
        }
    }

}

@Composable
fun Portafolio(datos: List<String>) {
LazyColumn{
    items(datos){
         item ->
         Card(modifier = Modifier
             .padding(15.dp)
             .fillMaxWidth(),
              shape = RectangleShape,
              elevation = 4.dp) {
             Row(modifier = Modifier
                 .padding(8.dp)
                 .background(MaterialTheme.colors.surface)
                 .padding(7.dp)) {
                 CrearImagenPerfil(modifier = Modifier.size(100.dp))
                 Column(modifier = Modifier.padding(7.dp)
                     .align(alignment = Alignment.CenterVertically)) {
                     Text(text = item, fontWeight = FontWeight.Bold)
                     Text(text = "En Jetpack Compose",
                     style = MaterialTheme.typography.body2)
                 }
             }
         }
    }
}
}

@Composable
private fun MostrarDatosPersonales() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Patricio L.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Analista Programador",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "patricio@Dev",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )

    }
}

@Composable
private fun CrearImagenPerfil(modifier: Modifier = Modifier) { //comentario
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_perfil1),
            contentDescription = "imagen de perfil",
            modifier = modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CartaPresentacionTheme {
        CrearCarta()
    }
}

