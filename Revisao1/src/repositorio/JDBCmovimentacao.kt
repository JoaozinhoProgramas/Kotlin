package repositorio

import java.sql.SQLException


fun JDBCmovimentacao() {
    val JDBC = JDBC()
    val c = JDBC.c

    try {
        JDBC.conectar()
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