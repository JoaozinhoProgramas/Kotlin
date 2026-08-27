package Financeiro

import java.math.BigDecimal
import java.time.LocalDate

class Banco(
    val valor : BigDecimal,
    val dataMovimentacao : LocalDate,
    //val pessoa : Pessoa depois de fazer a classe pessoa
) {
    fun Movimentar(valor : BigDecimal, data : LocalDate){

    }
}