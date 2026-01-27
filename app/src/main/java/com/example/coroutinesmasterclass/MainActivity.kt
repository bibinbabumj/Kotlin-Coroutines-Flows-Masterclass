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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val job = lifecycleScope.launch {
            val innerJob1 = launch {
                delay(2000L)
                println("Innerjob 1 finished")
            }
            val innerJob2 = launch {
                delay(1000L)
                println("Innerjob 2 finished")
            }
            innerJob1.cancel()
            delay(500L)
            println("is inner job 2 stll active:${innerJob2.isActive}")
            delay(600L)
            println("is inner job 2 stll active:${innerJob2.isActive}")
            println("is inner job 2 isCompleted:${innerJob2.isCompleted}")
            println("is inner job 2 isCancelled:${innerJob2.isCancelled}")

            setContent {
                CoroutinesMasterclassTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        // CounterScreen()
                    }

                }

            }
        }
    }
}