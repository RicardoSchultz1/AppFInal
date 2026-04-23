package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfinal.dp.CadastroDao
import kotlinx.coroutines.launch
import model.Cadastro

class CadastroViewModel(private val cadastroDao: CadastroDao) : ViewModel() {

    var uiState by mutableStateOf(Cadastro())
        private set

    var confirmarSenha by mutableStateOf("")
        private set

    val senhasDiferentes: Boolean
        get() = uiState.senha.isNotEmpty() && confirmarSenha.isNotEmpty() && uiState.senha != confirmarSenha

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
        confirmarSenha = novaConfirmacao
    }

    // Função para salvar no Banco de Dados
    fun registrar(onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                cadastroDao.insert(uiState)
                onSuccess()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
