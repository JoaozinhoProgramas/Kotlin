package repositorio

import java.sql.SQLException
import java.time.LocalDateTime


fun JDBCmovimentacao(contexto: String, valor: String, data: LocalDateTime) {
    val JDBC = JDBC()
    val c = JDBC.c

    try {
        JDBC.conectar()
        val sql = """
            INSERT INTO tabelaMuitoFoda 
            (contexto, valor, data) 
            VALUES (?,?,?) 
            """.trimIndent()

        val stmt = c!!.prepareStatement(sql)

        stmt.setString(1, valor.toString())
        stmt.setString(2, data.toString())
        stmt.setString(3, contexto)

        stmt.executeUpdate()
        stmt.close()
    } catch (e: SQLException) {
        e.printStackTrace()
    } finally {
        c?.close()
    }
}