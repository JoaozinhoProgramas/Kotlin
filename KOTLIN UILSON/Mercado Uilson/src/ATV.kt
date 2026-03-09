fun main () {
    do{
        println("MERCADO")
        println("Digite uma opção:")
        println(" 1 -> Adicionar Produto")
        println(" 1 -> Remover Produto")
        println(" 3 -> Encerrar Aplicação")
        var Choice : Int = readln().toInt()

        if (Choice == 1) {
            Insert()
        } else if (Choice == 2) {
            Remove()
        }
    }while (Choice != 3)
    print("Encerrando aplicação ...")

}

fun Insert () {
    println("Digite o nome do produto: ")
    val InsertProductName : String = readln()
    println("Digite o valor do produto: ")
    val InsertPriceProduct = readln().toDouble()
    val MapProduct = mapOf(InsertProductName to InsertPriceProduct)

    val ProductList : MutableList<Any> = mutableListOf(MapProduct)
    println(ProductList)
}

fun Remove() {

}