fun main() {
    
    var NameList : ArrayDeque <String> = ArrayDeque()
    var PriceList : ArrayDeque <Double> = ArrayDeque()
    var IDList : ArrayDeque <Int> = ArrayDeque()
    var QuantList : ArrayDeque <Int> = ArrayDeque()
    
    var Pid : Int = 0
    
    do{
        println("Mercado")
        println("1 - Comprar")
        println("2 - Vender")
        println("3 - Mostrar estoque")
        println("4 - Encerrar aplicação")
        
        val Choice : Int = readln().toInt()
        
        while(Choice != 4){
            when(Choice){
                1 -> {
                    println("={COMPRAS}=")
                        
                    println("Digite o nome do produto: (Digite S para sair)")
                    var PName : String = readln()
                        
                    if (PName.uppercase() == "S") {                        
                        println("Encerrando janela de compra ...")
                        break
                    }
                        
                    println("Digite a quantidade que irá comprar: ")
                    var PQuant : Int = readln().toInt()
                    
                        
                    println("Digite o valor do produto: ")
                    var PPrice : Double = readln().toDouble()
                    
                    println("=============")
                    println("ID: ${Pid}")
                    println("NOME: ${PName}")
                    println("PREÇO:R$ ${PPrice}" )
                    println("QUANTIDADE: ${PQuant} unid")
                    println("=============")
                   
                    NameList.addLast(PName)
                    QuantList.addLast(PQuant)
                    PriceList.addLast(PPrice)
                    IDList.addLast(Pid)
                    
                    Pid += 1
                } 
                2 -> println("Vendeu")
                3 -> {
                    println("={ESTOQUE}=")
                    var i : Int = 0
                    
                    for(y in 0 until NameList.size) {
                    
                        println("=============")
                        println("ID: ${IDList[i]}")
                        println("NOME: ${NameList[i]}")
                        println("PREÇO:R$ ${PriceList[i]}" )
                        println("QUANTIDADE: ${QuantList[i]} unid")
                        println("=============")
                        
                        i += 1
                    }
                    println("Deseja alterar algum produto? S/N")
                    var Change : String = readln().uppercase()
                    
                    if (Change == "S") {
                    
                        println("Digite o ID do produto que será alterado:")
                        var Pchange : Int = readln().toInt()
                        
                        println("Digite o novo valor do produto: ")
                        var PriceChange : Double = readln().toDouble()
                        
                        
                        PriceList[Pchange] = PriceChange
                        
                        println("Alterando valor, aguarde um momento ...")
                        Thread.sleep(1500)
                        println("Alteração concluida com sucesso")
                        
                        
                    }else if (Change == "N") {
                        println("Encerrando janela do estoque ...")
                        break
                        
                    } else {
                        println("Comando inválido, tente novamente")
                    }
                        
                    
                }
                4 -> {
                    println("Encerrando aplicação...")
                }
                    
                else -> {
                    println("Comando inválido, tente novamente")
                    break
                }
            }
        }

    }while(Choice != 4)
}