package br.pucpr.authserver.mensagens
import br.pucpr.authserver.mensagens.Mensagens
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository



@Repository
interface MysqlMensagensRepository : JpaRepository<Mensagens, Long>