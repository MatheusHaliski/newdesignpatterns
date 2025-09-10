package br.pucpr.authserver.mensagens
import com.fasterxml.jackson.annotation.JsonProperty

data class MensagemDTO(
    @JsonProperty("emailUser")
    val emailUser: String,
    @JsonProperty("emailDestinatario")
    val emailDestinatario: String,
    @JsonProperty("messageContent")
    val messageContent: String
)

