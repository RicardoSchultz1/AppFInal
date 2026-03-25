package com.example.appfinal.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.appfinal.R

@Composable
fun ModLogin(){

    var email by remember { mutableStateOf("") }

    Column(Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.pngfalso),
            contentDescription = "Imagem de login",
        )
        Text("Email")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true
            //label = { Text("E-mail") }
        )

        Text("Senha")

    }
}