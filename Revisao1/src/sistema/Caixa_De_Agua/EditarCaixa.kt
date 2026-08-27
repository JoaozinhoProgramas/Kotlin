package sistema.Caixa_De_Agua

import enumeradores.Cor
import enumeradores.Material
import produto.CaixaDaAgua
import repositorio.JDBC

fun editarCaixa() {
    val jpa = JDBC()
    jpa.listar()
    //Aqui exemplo de um item
    //Depois fazer os outros
    println("Digite uma caixa que deseja alterar: ")
    val id = readln().toInt()


    println("Digite a NOVA marca")
    val marca = readln()

    println("Digite o novo modelo ")
    val modelo = readln()

    println("Digite o novo formato ")
    val formato = readln()

    println("Digite a nova dimensão: ")
    println("Digite a nova largura: ")
    val largura = readln().toDouble()
    println("Digite a nova profundidade: ")
    val profundidade = readln().toDouble()
    println("Digite a nova altura: ")
    val altura = readln().toDouble()
    val dimensao = mutableListOf(largura, altura, profundidade)

    println("Escolha a cor ")

    Cor.entries.forEach { cor ->
        cor.ordinal
        println("${cor.ordinal} - ${cor.name.replace("_", " ")}")
    }
    println("Numero da cor NOVA: ")
    val cor = readln().toInt()

    println("Escolha o material ")
    Material.entries.forEach { material ->
        println("${material.ordinal} - ${material.name.replace("_", " ")}")
    }
    println("Numero do material NOVO: ")
    val material = readln().toInt()

    println("Digite o novo preço ")
    val preco = readln().toBigDecimal()

    jpa.editar(
        CaixaDaAgua(
            marca = marca,
            modelo = modelo,
            formato = formato,
            dimensao = dimensao,
            preco = preco,
            cor = Cor.entries[cor],
            material = Material.entries[material]

        ),
        id
    )
}
