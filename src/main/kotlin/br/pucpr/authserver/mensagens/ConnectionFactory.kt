package br.pucpr.authserver.mensagens
import java.sql.Connection

interface ConnectionFactory {
    fun get(): Connection
}
