package com.example.jetpackcompose

import android.content.res.Resources
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.core.content.res.ResourcesCompat
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
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
// view responsável por criar o card do video
fun VideoView(index: Int) {
    //alinhamento vertical
    Column(
        crossAxisSize = LayoutSize.Expand,
        mainAxisSize = LayoutSize.Wrap
    ) {

        //tamanho imagem
        Container(expanded = true, height = 200.dp) {
            DrawImage(image = +imageResource(R.drawable.tanlan))
        }

        Row() {
            Padding(padding = 8.dp) {
                Container(width = 32.dp, height = 32.dp) {
                    Clip(shape = CircleShape) {
                        DrawImage(image = +imageResource(R.drawable.tanlan2))
                    }
                }
            }

            Column(modifier = Spacing(8.dp)) {
                Text(text = "Hello, Android!",
                    style = +themeTextStyle { subtitle1 })
                Text(text = "Hello, World!$index",
                    style = +themeTextStyle { subtitle2.copy(color = Color.Gray) })

            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar<String>(title = {
            Text(text = "YouTube")
        }, actionData = emptyList(),
            navigationIcon = {
                Container(width = 32.dp, height = 32.dp) {
                    DrawImage(image = +imageResource(R.drawable.ic_yt))
                }
            }) {

    }
}


//não há necessidade de adapter, basta fazer integração das views
@Composable
fun Root() {
    //para a TopBar não cortar parte da imagem, precisa passar o modifier
    Container(modifier = Spacing(0.dp, 56.dp, 0.dp, 0.dp)) {

        //para manipular de forma vertical em uma rolagem
        VerticalScroller {
            Column(mainAxisSize = LayoutSize.Wrap) {
                for (i in 0..7) {
                    VideoView(index = i)
                }
            }
        }
    }
    Column() {
        TopBar()
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