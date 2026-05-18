package com.unipar.desafio_final_rpg.controller

import com.unipar.desafio_final_rpg.model.Personagem
import com.unipar.desafio_final_rpg.service.PersonagemService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient

@RestController
@RequestMapping("/combate")
class CombatController(
    @Value("\${rival.url}") private val rivalUrl: String,
    val restClient: RestClient,
    val personagemService: PersonagemService
) {
    var minhaEscolhaPersonagem = Personagem(0,"",0,0,0)
    //Para acessar o atacar agora eu uso: localhost:8080/combate/atacar
    @GetMapping
    fun atacar (poder : Int ){
        println("Estou batendo em vc")
        try {
            restClient.post()                      // Define que será uma requisição HTTP POST
                .uri(rivalUrl)                     // Define o destino: URL do rival (application.properties)
                .contentType(MediaType.TEXT_PLAIN) // Informa ao servidor rival que o corpo é texto puro (text/plain)
                .body(minhaEscolhaPersonagem.poder.toString())// Define o corpo da requisição com a mensagem
                .retrieve()                        // Dispara a requisição e prepara para ler a resposta
                .toBodilessEntity()                // Lê apenas os headers/status, ignora o corpo da resposta
        } catch (e: Exception){
            // Captura qualquer erro de rede ou HTTP (ex: rival offline, connection refused)
            println("Deu erro: ${e.message}")
        }
    }

    @PostMapping("/apanhar")
    fun apanhar (@RequestBody poder: Int ){
        println("Escolha seu personagem: ")
        print(personagemService.buscarTodos().forEach {
            print(it.nome)
        })
        val personagem = readln()
        try {
            minhaEscolhaPersonagem = personagemService.buscarPorNome(personagem) //busca para ver se o personagem esta no banco
            minhaEscolhaPersonagem.vida -= poder //desconta a vida do meu personagem
            personagemService.salvar(minhaEscolhaPersonagem) //salva o personagem no banco
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
        //1º SABER QUEM APANHOU
        //2º SABER O QUANTO APANHOU
    }

    //não é uma requisição http
    @GetMapping("/escolha/{nome}")
    fun escolherMeuPersonagem(@PathVariable nome: String ) : Personagem {
        //A partir daqui fica no console
        /*println("Escolha seu personagem: ")
        print(personagemService.buscarTodos().forEach {
            print(it.nome)
        })
        val personagem = readln()*/
        //Encerra a parte do console, é desnecessario, pois o path variable já faz via requisição
        try {
            minhaEscolhaPersonagem = personagemService.buscarPorNome(nome) //busca para ver se o personagem esta no banco

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
        return minhaEscolhaPersonagem
    }

}