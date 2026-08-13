package sistema


    fun menuInicial() {
        do {
            println("1 sair")
            println("2 cadastrar")
            println("3 editar")
            println("4 listar")
            println("5 excluir")
            val choice = readln().toInt()
            when (choice) {
                1 -> {
                    println("1 sair")
                    break
                }

                2 -> println("2 cadastrar")
                3 -> println("3 editar")
                4 -> println("4 listar")
                5 -> println("5 excluir")
            }
        } while (true)
    }
