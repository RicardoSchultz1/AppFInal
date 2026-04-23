package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class LoginFormState(
    val email: String = "",
    val senha: String = ""
)

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginFormState())
        private set

    fun updateEmail(novoEmail: String) {
        uiState = uiState.copy(email = novoEmail)
    }

    fun updateSenha(novaSenha: String) {
        uiState = uiState.copy(senha = novaSenha)
    }
}