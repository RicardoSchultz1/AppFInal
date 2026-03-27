package com.example.appfinal.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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

@Composable
fun CampoSenha(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Senha",
    //isError: Boolean = false
) {
    var senhaVisivel by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        //isError = isError,
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
