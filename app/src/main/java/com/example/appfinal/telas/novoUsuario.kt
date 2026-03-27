package com.example.appfinal.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appfinal.componentes.CampoSenha
import com.example.appfinal.viewmodels.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun novoUsuario(
    onVoltar: () -> Unit,
    viewModel: UsuarioViewModel = viewModel()
) {
    val state = viewModel.uiState

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Novo Usuário") },
            )
        }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Nome",
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = state.nome,
                onValueChange = { viewModel.updateNome(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Text(
                text = "Email",
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            OutlinedTextField(
                value = state.email,
                onValueChange = { viewModel.updateEmail(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Text(
                text = "Fone",
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            OutlinedTextField(
                value = state.fone,
                onValueChange = { viewModel.updateFone(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Text(text = "Senha", modifier = Modifier.padding(top = 16.dp))
            CampoSenha(
                value = state.senha,
                onValueChange = { viewModel.updateSenha(it) },
                //isError = state.senhasDiferentes
            )

            Text(text = "Confirmar Senha", modifier = Modifier.padding(top = 16.dp))
            CampoSenha(
                value = state.confirmarSenha,
                onValueChange = { viewModel.updateConfirmarSenha(it) },
                label = "Confirme sua senha",
                //isError = state.senhasDiferentes
            )

            if (state.senhasDiferentes) {
                Text(
                    text = "As senhas não coincidem",
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Button(
                onClick = { onVoltar() },
                enabled = !state.senhasDiferentes && state.senha.isNotEmpty() && state.fone.isNotEmpty() && state.email.isNotEmpty() && state.nome.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Text("Registrar")
            }
        }
    }
}
