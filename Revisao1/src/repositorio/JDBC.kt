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
}

