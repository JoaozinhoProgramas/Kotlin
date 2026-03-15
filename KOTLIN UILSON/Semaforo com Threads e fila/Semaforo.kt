/*Estrutura de 3 Threads, 
Traffic valida o estado do do Semaforo
CarSpawn cria os carros e os joga para a fila
CarOut libera os carros da fila, porem somente com a validação do if*/

fun main() {
    var end : Int = 0
    
    var CarNumber : Int = 0
    var OpenClose = false
    
    var Cars : ArrayDeque <Int> = ArrayDeque()
    
    val Traffic = Thread {
        while(end != 1){
            println("O Semaforo esta fechado")
            OpenClose = false
            Thread.sleep(10000)
            
            println("Semaforo esta aberto")
            OpenClose = true
            Thread.sleep(5000)
        }
    }
    
    val CarSpawn = Thread {
        while(end != 1){
            Thread.sleep(2000)
            CarNumber += 1
            println("O carro Nº ${CarNumber} chegou")
            Cars.addLast(CarNumber)
        }
    }
    
    val CarOut = Thread {
        while(end != 1){
            if(OpenClose == true && Cars.isNotEmpty()) {
                println("O carro a sair da vez é o carro Nº ${Cars.removeFirst()}")
                Thread.sleep(1000)    
            } else { //esse else serve pra a Thread não comer toda a memoria do programa, tirando ele a validação não funciona
                Thread.sleep(100)// é um valor pequeno só pra dar uma leve segurada, e não fazer o codigo rodar infinitamente 
            }
        }
    }
    
    Traffic.start()
    CarSpawn.start()
    CarOut.start()
    
}   