package sistema.Caixa_De_Agua

import enumeradores.Cor
import enumeradores.Habilidade
import enumeradores.Material
import enumeradores.Turno
import pessoas.Instalador
import produto.CaixaDaAgua
import repositorio.JPA
import java.awt.print.Printable
import java.math.BigDecimal

fun CadastrarCaixa(listaDeTeste : MutableList<CaixaDaAgua>){
    println("Digite a marca: ")
    var marca = readln()

    println("Digite a modelo: ")
    var modelo = readln()

    println("Digite a largura: ")
    var largura = readln().toDouble()

    print("Digite a altura: ")
    var altura = readln().toDouble()

    println("Digite a profundidade: ")
    var profund = readln().toDouble()

    val dimensao = mutableListOf<Double>(largura,altura,profund)

    println("Digite a cor: ")
    Cor.entries.forEach { cor ->
        println("${cor.ordinal} - ${cor.name}")
    }
    var cor = readln().toInt()

    println("Digite o material: ")
    Material.entries.forEach { material ->
        println("${material.ordinal} - ${material.name}")
    }
    var material = readln().toInt()

    println("Digite o formato: ")
    var formato = readln()

    println("Digite o preço: ")
    var preco = readln().toBigDecimal()

    val conexao = JPA()
    conexao.salvar(
        CaixaDaAgua(
            marca = marca,
            modelo = modelo,
            dimensao = dimensao,
            cor = Cor.entries[cor],
            material = Material.entries[material],
            formato = formato,
            preco = preco
        )
    )
}
