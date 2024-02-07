package br.com.liturgico.testandokotlin.dto.request

import br.com.liturgico.testandokotlin.entity.Organization

data class CreateOrganizationRequest(
    val name: String
) {
    fun toEntity(): Organization = Organization(
        name = this.name
    )
}
