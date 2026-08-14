package sistema.Caixa_De_Agua

import produto.CaixaDaAgua
import java.text.NumberFormat
import java.util.Locale

fun listarCaixa(listaDeTeste : MutableList<CaixaDaAgua>){
    var Formatador = NumberFormat.getNumberInstance(Locale("pt", "BR"))
    var caixaDeAgua: List<CaixaDaAgua> = listOf()
    caixaDeAgua.forEach { c ->
        println("Modelo : ${c.modelo}")
        println("Marca : ${c.marca}")
        println("Dimensão : ${c.dimensao}")
        println("Cor : ${c.cor}")
        println("Formato : ${c.formato}")
        println("Material : ${c.material}")
        println("Preco : ${Formatador.format(c.preco)}")
    }
}