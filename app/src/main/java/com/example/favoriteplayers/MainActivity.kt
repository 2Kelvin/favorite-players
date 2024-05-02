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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

// Player object structure
data class Player(
    val imageId: Int,
    val name: String,
    val jerseyNumber: Int,
    val position: String,
    val team: String,
)

// list of all my players
val myListOfPlayers = listOf(
    Player( // curry
        imageId = R.drawable.crry,
        name = "Stephen Curry",
        jerseyNumber = 30,
        position = "Point Guard",
        team = "Golden State Warriors"
    ),
    Player( // kawhi
        imageId = R.drawable.kawhileo,
        name = "Kawhi Leonard",
        jerseyNumber = 2,
        position = "Small Forward",
        team = "Los Angeles Clippers"
    ),
    Player( // ronaldo
        imageId = R.drawable.roro,
        name = "Christiano Ronaldo",
        jerseyNumber = 7,
        position = "Striker / Left Winger",
        team = "Al Nassir"
    ),
)

@Composable
fun FavoritePlayersApp(modifier: Modifier = Modifier) {
    // state
    var arrId by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .padding(top = 100.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        Column(modifier = modifier.weight(1f)) {
            // reusable PlayerCard
            // access the player using their index in the array
            PlayerCard(myListOfPlayers[arrId])
        }

        // buttons
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ReusableElevatedButton(
                btnText = "Previous",
                // move to the previous array index if the index is not 0 (the first player)
                handleClick = { if (arrId > 0) arrId-- else arrId = 0 },
                modifier = modifier.weight(1f)
            )

            Spacer(modifier = modifier.width(50.dp))

            ReusableElevatedButton(
                btnText = "Next",
                // move to the next array index if not in the array's last item index or higher
                handleClick = { if (arrId < myListOfPlayers.size - 1) arrId++ else arrId = 0 },
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun PlayerCard(
    player: Player,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            // take all the weight(1f) height of the screen
            .fillMaxHeight()
    ) {
        ElevatedCard(
            modifier = modifier
                .weight(1f)
                .background(Color.White),
            // custom Card border-radius
            shape = RoundedCornerShape(5.dp),
            // add more card shadow | through elevation
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Image(
                painter = painterResource(id = player.imageId),
                contentDescription = player.name,
                // make the image fill the 1f weight height
                contentScale = ContentScale.FillHeight,
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(40.dp)
                    // custom Image border-radius
                    .clip(shape = RoundedCornerShape(3.dp))
            )
        }

        Spacer(modifier = modifier.height(40.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFededf1))
                .padding(horizontal = 15.dp, vertical = 25.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = player.name + " (${player.jerseyNumber})", fontSize = 20.sp)
            Text(
                text = player.position,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
            )
            Text(text = player.team, fontSize = 16.sp)
        }
    }
}

// reusable elevated button
@Composable
fun ReusableElevatedButton(btnText: String, handleClick: () -> Unit, modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = handleClick,
        modifier = modifier.height(50.dp),
        // set button background-color
        colors = ButtonDefaults.buttonColors(Color.Black),
        // set custom button border-radius
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text = btnText, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FavoritePlayersTheme {
        FavoritePlayersApp()
    }
}