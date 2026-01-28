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
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ///1. FIRST VERSION (Two child coroutines + join)
        /*  val job = lifecycleScope.launch {
              val innerJob1 = launch {
                  delay(2000L)
                  println("InnerJob 1 finished")
              }
              val innerJob2 = launch {
                  delay(1000L)
                  println("InnerJob 2 finished")
              }


              ///What happens
              //
              //innerJob1 starts → delays 2000 ms.
              //
              //innerJob2 starts → delays 1000 ms.
              //
              //They run concurrently.
              val timeMilleSeconds = measureTimeMillis {
                  innerJob1.join()    // waits until innerJob1 completes (2 seconds)
                  innerJob2.join()    // innerJob2 already completed earlier (1 second)

              }

              println("Jobs took : $timeMilleSeconds milliseconds")
          }*/


        //SECOND VERSION (Sequential delays)
        /* val job2 = lifecycleScope.launch {

             val timeMilleSeconds = measureTimeMillis {
                 delay(2000L)
                 println("InnerJob 1 finished")

                 delay(1000L)
                 println("InnerJob 2 finished")
             }

             println("Jobs took : $timeMilleSeconds milliseconds")
         }*/


        // Deferred
       /* val jobDeferred = lifecycleScope.launch {

            val profileDeferred = async {
                println("Fetching profile data....")
                delay(1000L)
                "profile"
            }

            val postDeferred = async {
                println("Fetching post data....")
                delay(2000L)
                "post"
            }

            val timeMilleSeconds = measureTimeMillis {
                val profile = profileDeferred.await()
                val post = postDeferred.await()

                println("profile loaded: $profile, $post")
            }
            println("Jobs took : $timeMilleSeconds milliseconds")
        }*/


        setContent {
            CoroutinesMasterclassTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CounterScreen()
                }

            }

        }
    }
}