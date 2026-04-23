package model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class EsqueciSenhaFormState(
    val email: String = ""
)

class EsqueciSenhaViewModel : ViewModel() {
    var uiState by mutableStateOf(EsqueciSenhaFormState())
        private set

    fun updateEmail(novoEmail: String) {
        uiState = uiState.copy(email = novoEmail)
    }
}