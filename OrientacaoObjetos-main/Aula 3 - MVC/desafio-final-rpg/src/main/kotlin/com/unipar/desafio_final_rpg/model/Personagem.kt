package com.unipar.desafio_final_rpg.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Personagem (
    @Id // O id será a chave primária, mas você deve enviá-lo no Postman
    val id: Int,

    var nome: String,
    var poder: Int,
    var velocidade: Int,
    var vida: Int
)

/*
Desse jeito, o nome está como PK, ou seja, só vai puxar personagens quando for buscado pelo ID, caso buscar pelo nome ou
qualquer outra brisa, vai voltar o "personagem base"(valores zerados)
 */