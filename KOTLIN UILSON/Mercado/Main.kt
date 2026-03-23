fun main() {
    
    do{
        println("Mercado")
        println("1 - Comprar")
        println("2 - Vender")
        println("3 - Alterar Mercadoria")
        println("4 - Encerrar aplicação")
        
        val Choice : Int = readln().toInt()
        
        while(Choice != 4){
            when(Choice){
                1 -> {
                    println("={COMPRAS}=")
                    
                    var Pid : Int = 0
                    val product : cProduct = Product()//dar um jeito de instanciar
                        
                    println("Digite o nome do produto: (Digite S para sair)")
                    product.PName = readln()
                        
                    if (PName.uppercase() == "S") {                        
                        println("Encerrando compra ...")
                        break
                    }
                        
                    println("Digite a quantidade que irá comprar: ")
                    product.PQuant = readln().toInt()
                        
                    println("Digite o valor do produto: ")
                    product.PPrice = readln().toDouble()
                    
                    Pid += 1
                } 
                2 -> println("Vendeu")
                3 -> println("Compre algo antes")
                4 -> {
                    println("Encerrando aplicação...")
                }
                    
                else -> println("Comando inválido, tente novamente")
            }
        }

    }while(Choice != 4)
}
