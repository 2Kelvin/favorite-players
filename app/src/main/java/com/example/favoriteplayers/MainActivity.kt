package com.example.favoriteplayers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .padding(10.dp)
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(modifier = modifier.weight(1f)) {
            // reusable PlayerCard here
        }

        // buttons
        Row(
            modifier = modifier
                .background(Color.Yellow)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FavoritePlayersTheme {
        FavoritePlayersApp()
    }
}