import produto.CaixaDaAgua
import sistema.Caixa_De_Agua.CadastrarCaixa
import sistema.Caixa_De_Agua.CompraCaixa
import sistema.menuCaixaDeAgua
import sistema.menuCaixaDeAgua
import java.awt.print.Printable

fun main(){
    println("MENU INCIAL")
    do {
        println("1- Menu Compra")
        println("2- Menu Caixa")

        val choice = readln().toInt()

        when(choice) {
            1 -> CompraCaixa()
            2 -> menuCaixaDeAgua()
        }
    }while(true)

}
