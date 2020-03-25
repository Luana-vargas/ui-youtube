package com.example.jetpackcompose

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.core.content.res.ResourcesCompat
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Root()
            }
        }
    }
}

@Composable
fun Root(){
    //alinhamento vertical
    Column(crossAxisSize = LayoutSize.Expand,
            mainAxisSize = LayoutSize.Wrap) {

        //tamanho imagem
        Container(expanded = true, height = 200.dp) {
            DrawImage(+imageResource(R.drawable.tanlan))

        }

            Row(){
                Padding(padding = 8.dp) {
                Container(width = 32.dp, height = 32.dp) {

                    Clip(shape = CircleShape) {
                        DrawImage(+imageResource(R.drawable.tanlan2))
                    }
                }

                }
                
                Column (modifier = Spacing(8.dp)) {
                    Text(text = "Hello, Android!",
                            style = +themeTextStyle { subtitle1 } )
                    Text(text = "Hello, World!",
                            style = +themeTextStyle { subtitle2.copy(color = Color.Gray) })
                    
                }
            }
        }
    }



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}

// 42 min de video