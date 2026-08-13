package sistema.Caixa_De_Agua

import enumeradores.Cor
import enumeradores.Habilidade
import enumeradores.Material
import enumeradores.Turno
import pessoas.Instalador
import java.math.BigDecimal

fun CadastrarCaixa(){
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

    val dimensao = listOf<Double>(largura,altura,profund)

    println("Digite a cor: ")
    Cor.entries.forEach { cor ->
        println("${cor.ordinal} - ${cor.name}")
    }
    var cor = readln()

    println("Digite o material: ")
    Material.entries.forEach { material ->
        println("${material.ordinal} - ${material.name}")
    }
    var material = readln()

    println("Digite o formato: ")
    var formato = readln()

    println("Digite o preço: ")
    var preco = readln().toInt()
}
