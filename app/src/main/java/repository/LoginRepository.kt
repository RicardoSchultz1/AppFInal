package repository

import com.example.appfinal.dp.CadastroDao
import model.Cadastro

class LoginRepository(private val cadastroDao: CadastroDao) {
    suspend fun autenticar(email: String, senha: String): Cadastro? {
        return cadastroDao.login(email, senha)
    }
}
