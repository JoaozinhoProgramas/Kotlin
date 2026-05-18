package com.unipar.desafio_final_rpg.controller

import com.unipar.desafio_final_rpg.model.Personagem
import com.unipar.desafio_final_rpg.service.PersonagemService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient

// @RestController combina @Controller + @ResponseBody
// Indica que essa classe é um controlador HTTP e que todos os métodos
// retornam dados direto no corpo da resposta (não renderiza páginas HTML)
@RestController

class PersonagemController (
    // @Value injeta o valor da propriedade "rival.url" do application.properties
    // Ex: rival.url=http://192.168.1.12:8080/ouvir
    // Isso evita hardcodar IPs/URLs no código
    @Value("\${rival.url}") private val rivalUrl: String,

    // Injeção de dependência via construtor (padrão do Spring/Kotlin)
    // O Spring cria e gerencia as instâncias de PersonagemService e RestClient
    val personagemService: PersonagemService,


    val restClient: RestClient
) {
    @PostMapping("/salvar")
    fun salvar (@RequestBody personagem : Personagem){
        personagemService.salvar(personagem)
    }
}