package com.example.appfinal.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appfinal.R
import com.example.appfinal.componentes.CampoSenha
import com.example.appfinal.viewmodels.LoginViewModel

@Composable
fun ModLogin(
    onEsqueciSenhaClick: () -> Unit,
    onLoginClick: () -> Unit,
    onNovoUsuario: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.uiState

    Scaffold(
        topBar = {
            // TopBar vazia ou personalizada se desejar
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.pngfalso),
                contentDescription = "Imagem de login",
            )
            Text("Email")
            OutlinedTextField(
                value = state.email,
                onValueChange = { viewModel.updateEmail(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Text("Senha")
            CampoSenha(
                value = state.senha,
                onValueChange = { viewModel.updateSenha(it) },
                label = ""
            )

            Button(
                onClick = onLoginClick,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Login")
            }

            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = onNovoUsuario) {
                    Text("Novo Usuário")
                }
                TextButton(onClick = onEsqueciSenhaClick) {
                    Text("Esqueci a Senha")
                }
            }
        }
    }
}
