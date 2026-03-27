package com.example.appfinal

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destino {
    @Serializable
    data object login : Destino

    @Serializable
    data object esqueciSenha : Destino

    @Serializable
    data object menu : Destino

   @Serializable
    data object novoUsuario : Destino
}