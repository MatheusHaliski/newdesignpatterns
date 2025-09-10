package br.pucpr.authserver.ordersservice.src.main.java.com.example.ordersservice
import br.pucpr.authserver.mensagens.MensagemController
import br.pucpr.authserver.mensagens.MensagemDTO
import br.pucpr.authserver.mensagens.MensagemMapper
import org.springframework.web.bind.annotation.*

data class OrderRequest(val conteudo: String)

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val mensagemController: MensagemController,
    private val mapper: MensagemMapper
) {

    // variável em memória para armazenar o último valor
    private var ultimoPedido: String = "Lista de pedidos funcionando!"

    @GetMapping
    fun listOrders(): String {
        return ultimoPedido
    }

    @PostMapping
    fun escreverOrder(@RequestBody request: OrderRequest): String {
        ultimoPedido = request.conteudo

        val dto = mapper.toDtoFromTexto(request.conteudo)
        mensagemController.criarMensagem(dto)

        return "Você escreveu: ${request.conteudo}"
    }

}
