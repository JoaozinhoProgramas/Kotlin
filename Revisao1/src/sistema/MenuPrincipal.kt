package sistema

import produto.CaixaDaAgua
import sistema.Caixa_De_Agua.CadastrarCaixa
import sistema.Caixa_De_Agua.listarCaixa



fun menuInicial() {
    val listaDeTeste = mutableListOf<CaixaDaAgua>()
        do {
            println("1 sair")
            println("2 cadastrar")
            println("3 editar")
            println("4 listar")
            println("5 excluir")
            val choice = readln().toInt()
            when (choice) {
                1 -> {
                    break
                }

                2 -> {
                    CadastrarCaixa(listaDeTeste)
                }

                3 -> listarCaixa(listaDeTeste)
                4 -> println("4 listar")
                5 -> println("5 excluir")
            }
        } while (true)
    }
