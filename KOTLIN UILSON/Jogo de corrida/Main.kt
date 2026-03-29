//Das linhas 179 até 215 foi utilizado IA, mesmo estudando no Stack Overflow, lendo de cabo a rabo as bibliotecas, não consegui fazer esse placar sozinho :D
//foram 2 madrugadas viradas pra fazer isso    

fun main() {
    val ObjCircuit = Circuit()
    
    do{
        println("={COPA PISTÃO}=")
        println("1 -> Iniciar")
        println("2 -> Sair")
    
        var Choice = readln().toInt()
    
        when(Choice) {
            1 -> {
                ObjCircuit.CreateCircuit()
            }
        
            2 -> {
                break
            }
        }
        
        println("Deseja jogar novamente? S/N")
        var end = readln().uppercase()
        
        if (end == "S") {
            println("Certo, reiniciando applicação")
        } else {
            println("Encerrando aplicação ...")
            break
        }
    }while(Choice != 2)
    
}

class Pilot {
    var Name : String = ""
    var Ability : Double = 0.0
    
    fun CreatePilot() {
        println("Crie seu piloto: ")
        println("Digite o nome de seu piloto:")
        
        this.Name = readln()
    
        println("Digite a idade de seu piloto:")
        var Age = readln().toInt()
    
        var AbilityVerify : Boolean = false 
        while(AbilityVerify == false){
            println("De 1 a 10, digite o nivel da habilidade de seu piloto: (Atributo muito importante >:D )")
            this.Ability = readln().toDouble()
        
            if(Ability > 10.0) {
                Thread.sleep(1000)
                println("Danadinho, eu vi oque tentou fazer, tente novamente")
            } else {
                println("Piloto ${this.Name} criado com sucesso")
                AbilityVerify = true
            }
        }
        
        return
    }
    
    var AdversaryList : ArrayDeque <Any> = ArrayDeque()
    
    fun CreateAdversary(): ArrayDeque <Any> {
    
        var Index : Int = 0
        var AdversaryNames = mutableListOf(
            "Ana Banana","Bruno Mazeu","Carimbo","xX_Destroyer_Xx",
            "Não tive ideia pra letra E","Fernando Casas","Gigigante",
            "Henrique rei delas","Jiroscopio","KeroTudoh",
            "Livia Olivia","Mão invisel do estado")
        
        println("Digite a quantidade de corredores: (Quantidade Maxima ${AdversaryNames.size})")
        var AdversaryQuant = readln().toInt()
        
        var ReAdversaryList : ArrayDeque <Any> = ArrayDeque()
        for(i in 1..AdversaryQuant) {
            var AdversaryName = AdversaryNames.random()
            var AdversaryAbility : Int = (1..10).random()
            
            AdversaryNames.remove(AdversaryName)
            Index += 1 
            
            var AdversaryMap = mapOf(AdversaryName to AdversaryAbility)
            ReAdversaryList.addLast(AdversaryMap)
        }
        this.AdversaryList = ReAdversaryList
        return ReAdversaryList
    }
}

data class Car( var id : Int = 0, var speed : Int = 0) {
   
    fun CarSpawn(): List<Car> {
        var CarsList  = mutableListOf<Car>()
        var CarNumber : Int = 0

        println("Digite quantos carros terá a corrida: ")
        var CarsQuant = readln().toInt()
        
        for (i in 1..CarsQuant) {
            var Velocity : Int = (60..100).random()
            var Acceleration : Int = (1..4).random()
            var Airresist : Int = (1..6).random()
            
            var ActualSpeed : Int = Velocity * Acceleration / Airresist
            CarNumber += 1
            
            CarsList.add(Car(id = CarNumber, speed = ActualSpeed))
            
        }
        return CarsList.sortedByDescending { it.speed }
    }
}

class Circuit {
    
    fun CreateCircuit() {
        val ObjCar = Car()
        val ObjPilot = Pilot() 
        
        ObjPilot.CreatePilot()
        ObjPilot.CreateAdversary()
        
        println("Escolha a pista que irá correr:")
        println("1 -> Circuito Nevado")
        println("2 -> Circuito Arido")
        var CircuitChoice = readln().toInt()
        
        when(CircuitChoice){
            1-> {
                val TrackName : String = "PICOS NEVADOS"
                println("={$TrackName}=")
                ScoreBoard(ObjPilot, ObjCar, TrackName)
            }
            2 -> {
                val TrackName : String = "DUNAS ARDENTES"
                println("={$TrackName}=")
                ScoreBoard(ObjPilot, ObjCar, TrackName)
            }
        }
    }
    
    fun ScoreBoard(a: Pilot, b : Car, TrackName : String) {
        
        val ReturnObjCar = b.CarSpawn()
        
        println("\n--- PLACAR INICIAL ---")
        println("Piloto: ${a.Name} | Habilidade: ${a.Ability}")
        println("Adversários confirmados: ${a.AdversaryList.size}")
        println("----------------------")
        
        println("Escolha seu carro: (Selecione por numero)")
        ReturnObjCar.forEach { carro ->
            println("CARRO: ${carro.id} / VELOCIDADE: ${carro.speed}")
            println("-----------")
        }
        var CarChoice = readln().toInt()
        println("Iniciando corrida...")
        
        var Lights = listOf("🔴", "🟡", "🟢")    
        Lights.forEach { Start ->
            Thread.sleep(1500)    
            println(Start)
        }
        
        print("[")
        for (i in 1..10) {
            Thread.sleep(1000)
            print("=")
        }
        println("]")
        println("-------------")
        
            
        val MyCar = ReturnObjCar.find { it.id == CarChoice }
        val myFinalScore = (MyCar?.speed ?: 0).toDouble() * a.Ability

        // 2. Criar uma lista de resultados para comparar
        // Usaremos uma Data Class auxiliar ou um Pair para facilitar a ordenação
        val results = mutableListOf<Pair<String, Double>>()
    
        // Adiciona o jogador
        results.add(Pair("${a.Name} (Você)", myFinalScore))

        // Adiciona os adversários
        a.AdversaryList.forEach { item ->
        val map = item as Map<String, Int>
        val name = map.keys.first()
        val ability = map.values.first()
        
        // Simulando que cada adversário pegou um carro aleatório da lista
        val randomCarSpeed = ReturnObjCar.random().speed
        val adversaryScore = randomCarSpeed.toDouble() * ability
        
        results.add(Pair(name, adversaryScore))
        }

        // 3. Ordenar do maior para o menor
        val ranking = results.sortedByDescending { it.second }

        // 4. Exibir o Placar Final
        println("\n={RESULTADO FINAL DA CORRIDA}=")
        ranking.forEachIndexed { index, result ->
            val medal = when(index) {
                0 -> "🥇"
                1 -> "🥈"
                2 -> "🥉"
                else -> "${index + 1}º"
            }
            println("$medal ${result.first} - Pontuação: ${"%.1f".format(result.second)}")
        }

        if (ranking.first().first.contains("(Você)")) {
            println("Ao vencedor, a gloria, Você venceu a Copa Pistão na pista $TrackName!")
        } else {
            println("Ao perdedor, a vergonha, voce perdeu a Copa Pistão na pista $TrackName!")
        }
    }    
}
