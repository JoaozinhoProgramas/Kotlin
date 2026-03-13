package Pilhas.src

import java.lang.Thread.sleep//import do sleep

/* LAMBDA -> significa ação
   DIAMANTE <> significa tipagem
 */

fun main (){
    val Trheads1 = Thread{
        //sleep(1000)//temporizador
        for (i in 1..100) {
            println("$i")
        }
    }
    Trheads1.start()//sempre sera preciso inicializar a Thread

    Trheads1.join()//faz outras Trheads espereram ela acabar

    val Trheads2 = Thread {
        println("ACABOU !!!!")
    }
    Trheads2.start()

    println("Threads1 ainda esta operando?: ")
    when(Trheads1.isAlive) {//verifica se a Thread concluiu a execução
        true -> { println("Sim") }
        false -> { println("Não") }
    }

    criarPilha()
    criarFila()

    val Thread3 = Thread {
        for (i in 1..10) {
            print("${i}")
        }
    }

    val Thread4 = Thread {
        for (i in 11..20) {
            print("${i}")
        }
    }

    val Thread5 = Thread {
        for (i in 21..30) {
            print("${i}")
        }
    }

    Thread3.start()
    Thread4.start()
    Thread5.start()

    Thread3.priority = Thread.MIN_PRIORITY
    Thread4.priority = Thread.NORM_PRIORITY
    Thread5.priority = Thread.MAX_PRIORITY
}

fun criarPilha() {
    val pilha : ArrayDeque<String> = ArrayDeque()
    pilha.add("Áz de espadas")//adicionando na pilha
    pilha.add("Dois de ouro")//adicionando na pilha
    pilha.add("Tres de paus")//adicionando na pilha
    pilha.add("Quatro de copas")//adicionando na pilha

    println("A carta no topo da pilha é: ${pilha.last()}")//remove o topo da pilha

    for(i in 1..3) {
        pilha.remove(pilha.last())
        println("A carta no topo da pilha atualmente é: ${pilha.last()}")
    }
}

fun criarFila() {
    val fila : ArrayDeque<String> = ArrayDeque()
    fila.addLast("Fulano")//adicionando na fila
    fila.addLast("Mariazinha")//adicionando na fila
    fila.addLast("Paulinho")//adicionando na fila
    fila.addLast("Joãozinho")//adicionando na fila

    println("O primeiro a ser atendido da fila é: ${fila.removeFirst()}")//remove o primeiro da fila

    for (i in 1..3) {
        println("Quem será atendido agora é: ${fila.removeFirst()}")
    }
}