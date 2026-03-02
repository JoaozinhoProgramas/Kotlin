fun main() {
    /*val name : String = "Xaolin matador de porco"

    print("Olá $name, digite sua idade:")
    val ageString : String = readln()
    val ageInt : Int = ageString.toInt()

    print("Idade inteiro: $ageInt")

    print("Digite um calculo: ")

    val sign = readln().trim()
    var result = 0;

    if(sign.contains("+")) {
        print("SOMA")
        var split = sign.split("+").toString()

        print(split[0])
        print(split[1])

        split.toInt()

        var first = split[0]
        var second = split[1]

        print(first)
        print(second)
    }
    if(sign.contains("-")) {
        print("SUBTRAÇÃO")
    }
    if(sign.contains("*")) {
        print("MULTIPLICAÇÃO")
    }
    if(sign.contains("/")) {
        print("DIVISÃO")
    }*/

    coleçoes()

    // -> essa é a lamba
}
fun intervalos() {
    for ( y in 1..10) { // esse 1..10 é um intervalo, seria a mesma brisa de int i; i < 10; i++
        //IN é pra inserir o o intervalo, IN de INserir
        print("Esse é o loop $y")
        print("\n")
    }

    print("HORA DA INVERSÃO")
    print("\n")

    for ( x in 10 downTo 1) { //Mesma logica dos .., mas agora é regressiva
        print("Esse é o loop $x")
        print("\n")
    }
}

fun quando() {
    print("Digite um numero de 1 a 7: ")
    val day : Int = readln().toInt() //readln devolve uma String

    when(day){
        1 -> print("Domingo xablau")
        2 -> print("Odeio segundas")
        3 -> print("Acabou a criatividade pra terça feira")
        4 -> print ("Meio da semana")
        5 -> print("Dia internacional de queimar a largada (É quinta feira)")
        6 -> print("ACABOU O SOSSEGO")
        7 -> print("ACABOU O SOSSEGO 2")

    }
}

fun coleçoes() {
    print("Array de String: \n")
    val alnofabeto = arrayOf("a", "e", "i", "o", "u", "l", "m", "n", "q")

    print("Array de Inteiros: \n")
    val numerosPares = arrayOf(2, 4, 6, 8, 10, 12);

    for( i in 0 until alnofabeto.size) {
        print("Index String: $i, Valor ${alnofabeto[i]} \n")

        if ( i in 0 until numerosPares.size) {
            print(("Index Int: $i, Valor ${numerosPares[i]} \n"))
        } else {
            print("Index Int: Acabou os numeros \n")
        }
    }
}
