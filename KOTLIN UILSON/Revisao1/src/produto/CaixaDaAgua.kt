package produto

import enumeradores.Cor
import enumeradores.Habilidade
import enumeradores.Material
import enumeradores.Turno
import pessoas.Instalador
import java.math.BigDecimal

class CaixaDaAgua (
    /**
     * Marca, Modelo, Dimensão(altura, largura, profundidade), enumeradores.Cor, enumeradores.Material, Formato, pessoas.Instalador, Preço, Fornecedor
     * */
    val marca : String = "nome da marca",
    val modelo : String = "nome da modelo",
    val dimensao : MutableList<Double> = mutableListOf(0.0, 0.0, 0.0),
    val cor : Cor = Cor.AZUL_FRACO,
    val material : Material = Material.FIBRA_DE_VIDRO,
    val formato : String = "tipo do formato",
    val instalador : Instalador = Instalador(
        nome = "",
        cpf = "",
        idade = 0,
        salario = BigDecimal.ZERO,
        turno = Turno.NOTURNO,
        habilidade = Habilidade.INSTALACAO
    ),
    val fornecedor : String = "nome do fornecedor",
    val preco : BigDecimal = BigDecimal.ZERO
)