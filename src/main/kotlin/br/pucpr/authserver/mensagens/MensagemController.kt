package br.pucpr.authserver.mensagens
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mensagens")
class MensagemController(
    private val service: ServiceMensagem,
    private val mapper: MensagemMapper
) {
    @PostMapping("/mysql")
    fun criarMensagemM(@RequestBody mensagemDto: MensagemDTO): ResponseEntity<Mensagens> =
        ResponseEntity.ok(service.insert1(mapper.toEntity(mensagemDto)))

    @PostMapping
    fun criarMensagem(@RequestBody mensagemDto: MensagemDTO): ResponseEntity<Mensagens> =
        ResponseEntity.ok(service.insert(mapper.toEntity(mensagemDto)))


    @GetMapping
    fun listarMensagens(): ResponseEntity<List<MensagemDTO?>> {
        val entidades = service.lista() // retorna List<br.pucpr.authserver.mensagens.Mensagens>
        val dtos = entidades.map { mapper.toDTO(it) }
        return ResponseEntity.ok(dtos)
    }

    @GetMapping("/{remetente}/{destinatario}")
    fun listaEntreUsuarios(
        @PathVariable remetente: String,
        @PathVariable destinatario: String
    ): List<Mensagens> =
        service.listaEntreUsuarios(remetente, destinatario)

    @DeleteMapping("/{id}")
    fun deletarMensagem(@PathVariable id: Long) {
        service.deletarMensagemId(id)
    }
}
