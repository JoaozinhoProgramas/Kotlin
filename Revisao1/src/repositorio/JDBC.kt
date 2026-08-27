package repositorio

import produto.CaixaDaAgua
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

//porta: 5432
//usuario: postgres
//senha: postgres
//banco: NomePikaPraUmBanco
class JDBC(
    val user : String = "postgres",
    val password : String = "postgres",
    val url : String = "jdbc:postgresql://localhost:5432/NomePikaPraUmBanco",
    var c :Connection? = null
) {
    fun conectar() {
        try {
            //carregando o driver
            Class.forName("org.postgresql.Driver")
            //estabelecendo conexão
            c = DriverManager.getConnection(url, user, password)
            println("A conexão foi estabelecida com sucesso")
        } catch (e: SQLException) {
            print("Fudeu foi tudo, ERRO: ${e.printStackTrace()}")

        }
    }

    fun salvar(caixaDaAgua: CaixaDaAgua) {
        println("Salvando ...")
        try {
            conectar()
            val sql = """
            INSERT INTO tabelaMuitoFoda 
            (marca, modelo, dimensao, cor, material, formato, preco) 
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """.trimIndent()

            val stmt = c!!.prepareStatement(sql)

            stmt.setString(1, caixaDaAgua.marca)
            stmt.setString(2, caixaDaAgua.modelo)
            stmt.setArray(3, c!!.createArrayOf("float8", caixaDaAgua.dimensao.toTypedArray()))
            stmt.setString(4, caixaDaAgua.cor.name)
            stmt.setString(5, caixaDaAgua.material.name)
            stmt.setString(6, caixaDaAgua.formato)
            stmt.setString(7, caixaDaAgua.preco.toString())

            stmt.executeUpdate()
            stmt.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            c?.close()
        }
    }

    fun listar() {
        try {
            conectar()
            val stmt = c!!.createStatement()

            val sql = "SELECT * from caixa_da_agua"
            //metadados vem em forma de lista, ResultSet
            val metadados = stmt.executeQuery(sql)

            val resultado = metadados.metaData // Metadados
            val tamanhoTabela = resultado.columnCount//Tamanho da tabela em colunas

            while (metadados.next()) {
                for (i in 1..tamanhoTabela) {
                    //nome da coluna
                    val nomeColuna = resultado.getColumnName(i)
                    //dado que esta na coluna
                    val valorColuna = metadados.getObject(i)
                    println("$nomeColuna -> $valorColuna")
                } // fim for
                println("---------------------------------------------------")
            }//fim while


            stmt.close()
            c!!.close()

        } catch (e: SQLException) {
            println(e.printStackTrace())
        }

    }//Fim listar

    fun editar(caixa: CaixaDaAgua, id: Int) {
        try {
            conectar()
            val sql =
                "UPDATE caixa_da_agua SET preco = ?, marca = ?, modelo = ?, formato = ?, cor = ?, material = ?, dimensao = ? WHERE id = ?"
            //Continuar a logica para os outros itens

            val stmt = c!!.prepareStatement(sql)

            val doublePrecision = c!!.createArrayOf("float8", caixa.dimensao.toTypedArray())

            stmt.setString(1, caixa.preco.toString())
            stmt.setString(2, caixa.marca)
            stmt.setString(3, caixa.modelo)
            stmt.setString(4, caixa.formato)
            stmt.setString(5, caixa.cor.name)
            stmt.setString(6, caixa.material.name)
            stmt.setArray(7, doublePrecision)
            stmt.setInt(8, id)

            stmt.executeUpdate()//Faz as alterações e manda pro banco

            stmt.close()
            c!!.close()

        } catch (e: SQLException) {
            println(e.printStackTrace())
        }

    }

    fun excluir(id: Int) {
        try {
            conectar()
            val sql = "DELETE FROM caixa_da_agua WHERE id = ?"
            val stmt = c!!.prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.executeUpdate()

            c!!.close()


        } catch (e: SQLException) {
            println(e.printStackTrace())
        }
    }
}

