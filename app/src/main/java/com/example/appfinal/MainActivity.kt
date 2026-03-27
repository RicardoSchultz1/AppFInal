package com.example.appfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.appfinal.telas.ModLogin
import com.example.appfinal.telas.esqueciSenha
import com.example.appfinal.telas.menu
import com.example.appfinal.telas.novoUsuario
import com.example.appfinal.ui.theme.AppFInalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFInalTheme {
                val backStack = remember { mutableStateListOf<Destino>(Destino.login) }

                NavDisplay(
                    backStack = backStack,
                    onBack = { if (backStack.size > 1) backStack.removeLast() },
                    entryProvider = { key ->
                        when (key) {
                            Destino.login -> NavEntry(key) {
                                ModLogin(
                                    onEsqueciSenhaClick = { backStack.add(Destino.esqueciSenha) },
                                    onLoginClick = { backStack.add(Destino.menu) },
                                    onNovoUsuario = { backStack.add(Destino.novoUsuario) }
                                )
                            }
                            Destino.esqueciSenha -> NavEntry(key) {
                                esqueciSenha(
                                    onVoltar = { backStack.removeLast() }
                                )
                            }
                            Destino.menu -> NavEntry(key) {
                                menu(
                                    onVoltar = { backStack.removeLast() }
                                )
                            }
                           Destino.novoUsuario -> NavEntry(key) {
                                novoUsuario(
                                    onVoltar = { backStack.removeLast() }
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}
