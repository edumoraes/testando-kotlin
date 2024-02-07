package br.com.liturgico.testandokotlin.dto.response

import br.com.liturgico.testandokotlin.dto.ProgramMetaDto
import br.com.liturgico.testandokotlin.entity.Program

data class CreateProgramResponse(
    val id: Long?,
    val isPublic: Boolean?,
    val metadata: ProgramMetaDto?
) {
    constructor(program: Program) : this(
        id = program.id,
        isPublic = program.isPublic,
        metadata = ProgramMetaDto(program.metadata.title)
    )
}
