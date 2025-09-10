package br.pucpr.authserver.mensagens
import java.sql.Connection
import java.sql.DriverManager

class MysqlFactory(
    private val url: String = "jdbc:mysql://localhost:3306/mydb",
    private val user: String = "user",
    private val pass: String = "pass"
): ConnectionFactory {
    override fun get(): Connection = DriverManager.getConnection(url, user, pass)


}
