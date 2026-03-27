package com.example.appfinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class UsuarioFormState(
    val nome: String = "",
    val email: String = "",
    val fone: String = "",
    val senha: String = "",
    val confirmarSenha: String = ""
) {
    val senhasDiferentes: Boolean
        get() = senha.isNotEmpty() && confirmarSenha.isNotEmpty() && senha != confirmarSenha
}

class UsuarioViewModel : ViewModel() {
    var uiState by mutableStateOf(UsuarioFormState())
        private set

    fun updateNome(novoNome: String) {
        uiState = uiState.copy(nome = novoNome)
    }

    fun updateEmail(novoEmail: String) {
        uiState = uiState.copy(email = novoEmail)
    }

    fun updateFone(novoFone: String) {
        uiState = uiState.copy(fone = novoFone)
    }

    fun updateSenha(novaSenha: String) {
        uiState = uiState.copy(senha = novaSenha)
    }

    fun updateConfirmarSenha(novaConfirmacao: String) {
        uiState = uiState.copy(confirmarSenha = novaConfirmacao)
    }
}
