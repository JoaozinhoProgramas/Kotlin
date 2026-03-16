class Carro (
    val velocidade : Double,
    val dono : String// Sou obrigado a declarar
){


    fun atropelarPessoa(pessoa: Pessoa) {
        println("O carro atropelou ${pessoa.nome} em ${velocidade} Km/h")
    }

}