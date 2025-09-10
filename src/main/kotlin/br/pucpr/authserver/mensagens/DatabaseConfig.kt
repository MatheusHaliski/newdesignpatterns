package br.pucpr.authserver.mensagens
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.Connection
import java.sql.DriverManager

@Configuration
open class DatabaseConfig {
    @Bean
    open fun connection(): Connection {
        val url = "jdbc:h2:file:./data/testdb"
        return DriverManager.getConnection(url)
    }
    open fun connection2(): Connection {
        val url = "jdbc:mysql://localhost:3306/mydb"
        return DriverManager.getConnection(url)
    }
}
