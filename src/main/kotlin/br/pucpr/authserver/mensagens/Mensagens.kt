package br.pucpr.authserver.mensagens
import jakarta.persistence.*

@Entity
@Table(name = "mensagens")
open class Mensagens(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(nullable = false)
    open var emailUser: String = "",

    @Column(nullable = false)
    open var emailDestinatario: String = "",

    @Column(nullable = false)
    open var messageContent: String = ""
) {
    constructor() : this(null, "", "", "") // construtor no-arg obrigatório para o Hibernate
}
