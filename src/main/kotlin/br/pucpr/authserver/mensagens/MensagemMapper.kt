package br.pucpr.authserver.mensagens
import org.springframework.stereotype.Component
import java.sql.ResultSet

@Component
class MensagemMapper {

    // Mapper do JDBC → entidade
    fun fromResultSet(rs: ResultSet): Mensagens {
        val id = rs.getLong("id")
        val createdAt = try {
            rs.getTimestamp("created_at").time
        } catch (_: Throwable) {
            // fallback para SQLite
            System.currentTimeMillis()
        }
        return Mensagens(
            id = if (rs.wasNull()) null else id,
            emailUser = rs.getString("email_user"),
            emailDestinatario = rs.getString("email_destinatario"),
            messageContent = rs.getString("message_content"),

        )
    }

    // DTO → entidade
    fun toEntity(dto: MensagemDTO): Mensagens =
        Mensagens(
            emailUser = dto.emailUser,
            emailDestinatario = dto.emailDestinatario,
            messageContent = dto.messageContent
        )

    // entidade → DTO
    fun toDTO(mensagem: Mensagens): MensagemDTO? =
        mensagem.emailDestinatario?.let {
            MensagemDTO(
                emailUser = mensagem.emailUser,
                emailDestinatario = it,
                messageContent = mensagem.messageContent,
            )
        }

    fun toDtoFromTexto(texto: String): MensagemDTO =
        MensagemDTO(
            emailUser = "sistema@authserver.com",
            emailDestinatario = "orders@authserver.com",
            messageContent = texto
        )
}
