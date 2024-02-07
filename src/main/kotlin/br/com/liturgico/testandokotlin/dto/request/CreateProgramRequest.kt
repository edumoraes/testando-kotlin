package br.com.liturgico.testandokotlin.dto.request

import br.com.liturgico.testandokotlin.dto.ProgramMetaDto
import br.com.liturgico.testandokotlin.entity.Program
import br.com.liturgico.testandokotlin.entity.ProgramMeta
import java.io.Serializable

/**
 * DTO for {@link br.com.liturgico.testandokotlin.entity.Program}
 */
data class CreateProgramRequest(
    val isPublic: Boolean? = null,
    val metadata: ProgramMetaDto? = null
) : Serializable {
    fun toEntity(): Program = Program(
        isPublic = this.isPublic ?: false,
        metadata = this.metadata!!.toEntity() ?: ProgramMeta(),
    )
}