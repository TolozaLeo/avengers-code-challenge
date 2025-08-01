package dev.leotoloza.avengersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.leotoloza.avengersapp.ui.common.BottomBar
import dev.leotoloza.avengersapp.ui.common.TopBar
import dev.leotoloza.avengersapp.ui.theme.AvengersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvengersAppTheme {
//                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar("Avengers App") },
                    bottomBar = { BottomBar() },
                ) { innerPadding ->
//                    NavGraph(
//                        navController = navController,
//                        modifier = Modifier.padding(innerPadding),
//                    )
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AvengersAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar("MARVEL CHALLENGE") },
            bottomBar = { BottomBar() },
        ) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}