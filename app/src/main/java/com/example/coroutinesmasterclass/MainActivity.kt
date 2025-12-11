package com.example.coroutinesmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesmasterclass.ui.theme.CoroutinesMasterclassTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val  customScope=CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customScope.launch {
            println("Cutsom Scope")
        }
        GlobalScope.launch {
            println("Global scope")
        }

        lifecycleScope.launch {
            println("Life Cycle Scope")
        }
        enableEdgeToEdge()
        setContent {
            CoroutinesMasterclassTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Hello "
                    )
                }

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        customScope.cancel()
    }
}