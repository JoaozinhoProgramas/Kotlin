package sistema

import sistema.Caixa_De_Agua.CompraCaixa

fun menuSaldo(){
    do {
        println("1 - Consultar saldo")
        println("2 - Compra")
        println("3 - Venda")
        println("4 - Sair")
        val choice = readLine()!!.toInt()

        when (choice) {
            1 -> {
                println("Função do saldo")
            }

            2 -> CompraCaixa()

            3 -> {
                println("Função da venda")
            }

            4 -> {
                break
            }
        }
    }while (choice != 0)
}