package sistema.caixa_da_agua

import repositorio.JDBC

fun excluirCaixa(){
    val jpa = JDBC()
    jpa.listar()
    println("Digite o ID que deseja excluir: ")
    val id = readln().toInt()

    jpa.excluir(id)
}