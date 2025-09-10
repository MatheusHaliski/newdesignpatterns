package br.pucpr.authserver.mensagens

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HelloController {

    // GET simples
    @GetMapping("/hello")
    fun hello(): String {
        return "Servidor rodando com sucesso 🚀"
    }

    // POST com JSON
    @PostMapping("/echo")
    fun echo(@RequestBody body: Map<String, Any>): Map<String, Any> {
        return mapOf("recebido" to body)
    }

    // GET com parâmetro
    @GetMapping("/soma")
    fun soma(@RequestParam a: Int, @RequestParam b: Int): Map<String, Int> {
        return mapOf("resultado" to (a + b))
    }
}
