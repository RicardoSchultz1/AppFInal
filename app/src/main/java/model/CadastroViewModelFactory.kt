package model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfinal.dp.CadastroDao
import viewModel.CadastroViewModel

class CadastroViewModelFactory(private val cadastroDao: CadastroDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastroViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CadastroViewModel(cadastroDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
