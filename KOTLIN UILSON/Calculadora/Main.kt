val pilha = mutableMapOf< Int, String>()
var nivel = 0 //controla o nivel da pilha
var aux = " " + " "

fun main() {
    val regex = Regex("^[0-9+\\-*/()]+\$")//expressão regular

    println("Digite a expressaão")
    val exp = readln().replace(" ", "")// tira os espaços
    if (exp.matches(regex)) {
        println("Expressão aceita")
    } else {
        println("Expressão negada")
    }

    exp.forEach { c -> //lambida, famoso lambimia, esse c ->, serve pra renomear o it do forEach
        //varivel de controle
        var nivelAtual = nivel
        prioridade(c)

            if (nivel == nivelAtual) {

                aux += c.toString()

                //formando a equação nova no nivel X da pilha
                pilha[nivel] = aux//informação velha concatena com a nova
            } else {
                aux = " "
            }
        }
        pilha.forEach { (i, s) ->
            println("Nivel da pilha: $i")
            println("Valor da pilha: $s")
        }
    }

    fun prioridade(c : Char) : Int { //puxou c do forEach
        when(c) {
            '(' -> { //sobe o nivel da pilha
                return nivel++
            }

            ')' -> { //desce o nivel da pilha
                return nivel--
            }

            else -> {
                return nivel //não faz nada
            }
        }
    }