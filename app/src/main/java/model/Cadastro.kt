package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cadastros")
data class Cadastro(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val fone: String = "",
    val senha: String = ""
)
