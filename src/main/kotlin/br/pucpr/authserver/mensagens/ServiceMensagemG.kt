package br.pucpr.authserver.mensagens
import br.pucpr.authserver.mensagens.MensagensG
import br.pucpr.authserver.mensagens.MensagensGRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceMensagemG(private val repository: MensagensGRepository) {

    fun insert(mensagem: MensagensG): MensagensG = repository.save(mensagem)

    fun lista(): MutableList<MensagensG> = repository.findAll()

    fun deleteByUser(emailUser: String): Int = repository.deleteByUserId(emailUser)

    fun findById(id: Long): Optional<MensagensG> = repository.findById(id)
}
