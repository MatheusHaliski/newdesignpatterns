package br.pucpr.authserver.mensagens
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface MensagensGRepository : JpaRepository<MensagensG, Long> {
    fun findByEmailUser(emailUser: String): List<MensagensG>
    @Modifying
    @Transactional
    @Query("DELETE FROM MensagensG m WHERE m.emailUser = :emailUser")
    fun deleteByUserId(@Param("emailUser") emailUser: String): Int
    override fun findById(id:Long): Optional<MensagensG>
    fun save(msg: MensagensG): MensagensG
    override fun findAll(): MutableList<MensagensG>
}
