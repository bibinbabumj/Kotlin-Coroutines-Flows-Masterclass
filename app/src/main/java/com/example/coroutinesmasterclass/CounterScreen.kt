package com.example.coroutinesmasterclass

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun CounterScreen(modifier: Modifier= Modifier){
    var counter by remember {
        mutableIntStateOf(0)
    }
    /*LaunchedEffect(key1 = counter) {
        delay(500L)
    }*/
    Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = {counter++}) {
            Text(text = "Count:$counter")
        }
    }
}