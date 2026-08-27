package Financeiro

import java.math.BigDecimal

class Caixa(
    val saldo : BigDecimal,
) {
    fun receita(valor : BigDecimal) : BigDecimal {
        return valor
    }
    fun despesa(valor : BigDecimal) : BigDecimal {
        return valor
    }
}