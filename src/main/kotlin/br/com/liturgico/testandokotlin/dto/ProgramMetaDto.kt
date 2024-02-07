package br.com.liturgico.testandokotlin.dto

import br.com.liturgico.testandokotlin.entity.ProgramMeta
import java.io.Serializable

/**
 * DTO for {@link br.com.liturgico.testandokotlin.entity.ProgramMeta}
 */
data class ProgramMetaDto(val title: String? = null) : Serializable{
    fun toEntity() = this.title?.let {
        ProgramMeta(
        title = it
    )
    }
}