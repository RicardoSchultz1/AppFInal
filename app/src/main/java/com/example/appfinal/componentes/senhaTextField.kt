package com.example.appfinal.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lint.kotlin.metadata.Visibility

@Composable
fun CampoSenha() {
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = senha,
        onValueChange = { senha = it },
        label = { Text("Senha") },
        singleLine = true,
        visualTransformation = if (senhaVisivel)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        trailingIcon = {
            val icone = if (senhaVisivel)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                Icon(
                    imageVector = icone,
                    contentDescription = if (senhaVisivel) "Ocultar senha" else "Mostrar senha"
                )
            }
        }
    )
}