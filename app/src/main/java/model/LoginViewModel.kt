package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repository.LoginRepository

data class LoginFormState(
    val email: String = "",
    val senha: String = "",
    val mensagemErro: String? = null
)

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    var uiState by mutableStateOf(LoginFormState())
        private set

    fun updateEmail(novoEmail: String) {
        uiState = uiState.copy(email = novoEmail, mensagemErro = null)
    }

    fun updateSenha(novaSenha: String) {
        uiState = uiState.copy(senha = novaSenha, mensagemErro = null)
    }

    fun fazerLogin(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val usuario = repository.autenticar(uiState.email, uiState.senha)
            if (usuario != null) {
                onSuccess()
            } else {
                uiState = uiState.copy(mensagemErro = "Email ou senha incorretos")
            }
        }
    }
}