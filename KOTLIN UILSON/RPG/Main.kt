fun main() {
    var objPersonagem: Personagem = Personagem()
    
    println("Crie seu Personagem: ")
    print("Digite seu Nome: ")
    val nome = readln()
        
    print("""
    Digite sua Classe: 
    1 - Guerreiro
    2 - Mago
    3 - Ladino
    """)
            
    val escolha: Int = readln().toInt() 
        
    when(escolha) {
        1 -> {
            objPersonagem = Guerreiro(
                nome,
                vida = 20,
                forca = 20,
                atributoUnico = 15,
                velocidade = 1.2 )
                
            println("Você escolheu Guerreiro!")
        }
        2 -> {
            objPersonagem = Mago(
                nome, 
                vida = 12,
                forca = 15, 
                atributoUnico = 20,
                velocidade = 2.0 )
                
            println("Você escolheu Mago!")
        }
        3 -> {
            objPersonagem = Ladino(
                nome,
                vida = 8,
                forca = 8,
                atributoUnico = 25,
                velocidade = 3.5)
            println("Você escolheu Ladino!")
        }
        else -> println("Escolha errada, usando personagem padrão.")
    }

    println("\n--- AÇÃO ---")
    objPersonagem.usarPoder()
    println()
    objPersonagem.atacar()
}

open class Personagem (
    var nome: String = "",
    var vida: Int = 0,
    var forca: Int = 0,
    var atributoUnico: Int = 0,
    var velocidade: Double = 0.0
) {
    open fun usarPoder() {
        print("É o turno de $nome, ele ginga sua arma!")
    }
    
    fun atacar() {
        print("Durante seu turno, você ataca causando $forca de dano!")
    }
}

class Guerreiro(nome: String, atributoUnico: Int, vida: Int, forca: Int, velocidade: Double) : Personagem(nome, vida, forca, atributoUnico, velocidade) {
    override fun usarPoder() {
        print("O Guerreiro $nome usa sua Defesa de $atributoUnico para bloquear!")
    }
}

class Ladino(nome: String, atributoUnico: Int, vida: Int, forca: Int, velocidade: Double) : Personagem(nome, vida, forca, atributoUnico, velocidade) {
    override fun usarPoder() {
        print("O Ladino $nome usa sua Sagacidade ($atributoUnico) para um ataque crítico!")
    }
}

class Mago(nome: String, atributoUnico: Int, vida: Int, forca: Int, velocidade: Double) : Personagem(nome, vida, forca, atributoUnico, velocidade) {
    override fun usarPoder() {
        val calcDano = forca + vida + atributoUnico
        print("O Mago $nome lança um feitiço de $calcDano de dano!")
    }
}