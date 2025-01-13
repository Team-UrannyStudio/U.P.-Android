package com.example.up

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.up.act.add.RallyAddView
import com.example.up.act.nav.Home
import com.example.up.ui.theme.UPTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UPTheme {
                RallyAddView()
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    bottomBar = {
//
//                    }
//                ) { innerPadding ->
//                    Home(Modifier.padding(innerPadding))
//                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UPTheme {
        RallyAddView()
    }
}