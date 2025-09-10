package br.pucpr.authserver.mensagens

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/mensagensG")
class MensagemGController(private val service: ServiceMensagemG) {

    @PostMapping
    fun criarMensagem(@RequestBody mensagem: MensagensG): ResponseEntity<MensagensG> =
        ResponseEntity.ok(service.insert(mensagem))

    @GetMapping
    fun listarMensagens(): MutableList<MensagensG> = service.lista()

    @GetMapping("/id")
    fun listarMensagemById(id:Long): Optional<MensagensG> = service.findById(id)
}
