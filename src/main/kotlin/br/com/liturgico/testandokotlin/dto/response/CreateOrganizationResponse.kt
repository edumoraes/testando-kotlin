package br.com.liturgico.testandokotlin.dto.response

import br.com.liturgico.testandokotlin.entity.Organization

data class CreateOrganizationResponse(
    val id: Long,
    val name: String
) {
    constructor(organization: Organization) : this(
        id = organization.id!!,
        name = organization.name
    )
}
