package br.pucpr.authserver.mensagens
import br.pucpr.authserver.mensagens.Mensagens
import br.pucpr.authserver.mensagens.MensagensRepository
import br.pucpr.authserver.mensagens.MysqlMensagensRepository
import org.springframework.stereotype.Service

@Service
class ServiceMensagem(
    private val repository: MensagensRepository,
    private val mysqlRepo: MysqlMensagensRepository
) {
    fun insert(mensagem: Mensagens): Mensagens = repository.save(mensagem)

    fun insert1(mensagem: Mensagens): Mensagens = mysqlRepo.save(mensagem)

    fun lista(): List<Mensagens> = repository.findAll()

    fun listaEntreUsuarios(remetente: String, destinatario: String): List<Mensagens> =
        (repository.findByEmailUserAndEmailDestinatario(remetente, destinatario))


    fun deletarMensagemId(id: Long) {
        repository.deleteById(id)
    }
}
