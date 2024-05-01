package com.example.favoriteplayers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favoriteplayers.ui.theme.FavoritePlayersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavoritePlayersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoritePlayersApp()
                }
            }
        }
    }
}

@Composable
fun FavoritePlayersApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 80.dp, bottom = 15.dp, start = 15.dp, end = 15.dp)
            .fillMaxSize()
    ) {
        Column(modifier = modifier.weight(1f)) {
            // reusable PlayerCard here
            PlayerCard()
        }

        // buttons
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Previous"
                )
            }

            Spacer(modifier = modifier.width(50.dp))

            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Composable
fun PlayerCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            // take all the weight(1f) height of the screen
            .fillMaxHeight()
    ) {
        ElevatedCard(
            modifier = modifier
                .weight(1f)
                .background(Color.White),
        ) {
            Image(
                painter = painterResource(id = R.drawable.curry),
                contentDescription = "player",
                // make the image fill the 1f weight height
                contentScale = ContentScale.FillHeight,
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(30.dp)
            )
        }

        Spacer(modifier = modifier.height(50.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFededf1))
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Steph Curry (30)", fontSize = 18.sp)
            Text(
                text = "Point Guard",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
            )
            Text(text = "Golden State Warriors", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FavoritePlayersTheme {
        FavoritePlayersApp()
    }
}