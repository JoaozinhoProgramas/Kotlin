fun main() {
    val ObjCar = Car()
    val ObjPilot = Pilot()
    
    do{
        println("={COPA PISTÃO}=")
        println("1 -> Iniciar")
        println("2 -> Sair")
    
        var Choice = readln().toInt()
    
        when(Choice) {
            1 -> {
                println(ObjPilot.CreatePilot())
                println(ObjCar)//sem chamar a função, não printa nada, mas chamando a função. vai printar a lista inteira
                println(ObjPilot.CreateAdversary())        
            }
        
            2 -> {
                break
            }
        }    
    }while(Choice != 2)
    
    var ShowCars = Car().CarSpawn()
    var ShowAdversary = Pilot().CreateAdversary()
    /*println(ShowCars)
    println(ShowAdversary)*/
}

class Pilot {
    
    fun CreatePilot() {
        println("Crie seu piloto: ")
        println("Digite o nome de seu piloto:")
        var Name = readln()
    
        println("Digite a idade de seu piloto:")
        var Age = readln().toInt()
    
        var AbilityVerify : Boolean = false 
        while(AbilityVerify == false){
            println("De 1 a 10, digite o nivel da habilidade de seu piloto: (Atributo muito importante >:D )")
            var Ability = readln().toDouble()
        
            if(Ability > 10.0) {
                Thread.sleep(1000)
                println("Danadinho, eu vi oque tentou fazer, tente novamente")
            } else {
                println("Piloto criado com sucesso")
                AbilityVerify = true
            }
        }    
    }
    
    fun CreateAdversary(): ArrayDeque <String> {

        var AdversaryList : ArrayDeque <String> = ArrayDeque()
        var Index : Int = 0
        var AdversaryNames = mutableListOf(
            "Ana Banana","Bruno Mazeu","Carimbo","xX_Destroyer_Xx",
            "Não tive ideia pra letra E","Fernando Casas","Gigigante",
            "Henrique rei delas","Jiroscopio","KeroTudoh",
            "Livia Olivia","Mão invisel do estado")
        
        println("Digite a quantidade de corredores:")
        var AdversaryQuant = readln().toInt()
        
        for(i in 1..AdversaryQuant) {
            var AdversaryName = AdversaryNames.random()
            AdversaryNames.remove(AdversaryName)
            Index += 1 
            
            AdversaryList.addLast(AdversaryName)
        }
        return AdversaryList
    }
}

class Car {
   
    fun CarSpawn(): ArrayDeque <Any> {
        var CarsList : ArrayDeque <Any> = ArrayDeque()
        var CarNumber : Int = 0
        
        println("Digite quantos carros terá a corrida: ")
        var CarsQuant = readln().toInt()
        
        for (i in 1..CarsQuant) {
            var Velocity : Int = (60..100).random()
            var Acceleration : Int = (1..4).random()
            var Airresist : Int = (1..6).random()
            
            var ActualSpeed = Velocity * Acceleration / Airresist
            CarNumber += 1
            
            val CarMap = mapOf(ActualSpeed to CarNumber)
            
            CarsList.addLast(CarMap)

        }
        return CarsList
    }
}
