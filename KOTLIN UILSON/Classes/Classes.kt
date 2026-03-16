import javax.sql.rowset.CachedRowSet

/*
CARRO
Cor da lataria, Tamanho do aro da roda, Quantidade de marchas, É manual?, Quantidade de pistões do motor

ALIMENTO
Quantas calorias possui, Sabor, Modo de preparo, Precisa cultivar?, Preço

PESSOA
Altura, Peso, Cor do cabelo, Sexo, Cor da pele

INSTANCIAR:Criar algo, no caso, instanciar uma classe, estará criando uma classe

*/



fun main () {
    val pessoa : Pessoa = Pessoa()//isso é um objeto vazio
    println("Digite o nome de quem voce vai atropelar: ")
    pessoa.nome = readln()

    /*var carro : Carro = Carro ()
    print("Digite a velocidade de seu carro: ")
    carro.velocidade = readln().toDouble()*/

    val mustang : Carro = Carro(velocidade = 270.0, dono = pessoa.nome)//Explicito
    val fusca : Carro = Carro(150.0, pessoa.nome)//Implicito
    //Sou obrigado a seguir a ordem dos atributos



}