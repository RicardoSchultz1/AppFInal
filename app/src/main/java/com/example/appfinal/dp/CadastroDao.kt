package com.example.appfinal.dp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import model.Cadastro

@Dao
interface CadastroDao {
    @Insert
    suspend fun insert(cadastro: Cadastro)

    @Upsert
    suspend fun upsert(cadastro: Cadastro): Long

    @Update
    suspend fun update(cadastro: Cadastro)

    @Delete
    suspend fun delete(cadastro: Cadastro)

    @Query("SELECT * FROM cadastros order by nome")
    suspend fun findAll(): List<Cadastro>

}
