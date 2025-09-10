package br.pucpr.authserver

import org.hibernate.boot.model.FunctionContributions
import org.hibernate.boot.model.FunctionContributor
import org.hibernate.dialect.Dialect
import org.hibernate.dialect.identity.IdentityColumnSupportImpl
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport
import java.sql.Types

class SQLiteDialect : Dialect() {

    override fun getNameQualifierSupport(): NameQualifierSupport =
        NameQualifierSupport.NONE

    override fun getIdentityColumnSupport(): IdentityColumnSupportImpl {
        return object : IdentityColumnSupportImpl() {
            override fun getIdentitySelectString(table: String?, column: String?, type: Int): String {
                return "select last_insert_rowid()"
            }

            override fun getIdentityColumnString(type: Int): String {
                return "integer"
            }
        }
    }

 fun getTypeName(code: Int, length: Long, precision: Int, scale: Int): String {
        return when (code) {
            Types.INTEGER -> "integer"
            Types.VARCHAR -> "text"
            Types.BOOLEAN -> "integer"
            Types.REAL, Types.FLOAT, Types.DOUBLE -> "real"
            Types.BLOB -> "blob"
            Types.TIMESTAMP, Types.DATE -> "datetime"
            else -> super.castType(code)
        }
    }

    // Registrar funções SQL customizadas (Hibernate 6)
    override fun contributeFunctions(functionContributions: FunctionContributions) {
        val registry = functionContributions.functionRegistry
        val typeConfig = functionContributions.typeConfiguration

        registry.registerPattern(
            "lower",
            "lower(?1)"

        )
        registry.registerPattern(
            "upper",
            "upper(?1)"
        )
    }
}
