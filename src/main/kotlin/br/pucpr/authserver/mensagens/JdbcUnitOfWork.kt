package br.pucpr.authserver.mensagens
import java.sql.Connection

class JdbcUnitOfWork(
    private val factory: ConnectionFactory
) {
    private var connection: Connection? = null
    var inTransaction: Boolean = false

    fun begin() {
        if (inTransaction) throw IllegalStateException("Já existe uma transação ativa")
        connection = factory.get().apply {
            autoCommit = false
        }
        inTransaction = true
    }

    fun commit() {
        if (!inTransaction) throw IllegalStateException("Nenhuma transação ativa")
        connection?.commit()
        close()
    }

    fun rollback() {
        if (!inTransaction) throw IllegalStateException("Nenhuma transação ativa")
        connection?.rollback()
        close()
    }

    fun getConnection(): Connection {
        return connection ?: factory.get()
    }

    private fun close() {
        connection?.close()
        connection = null
        inTransaction = false
    }

}
