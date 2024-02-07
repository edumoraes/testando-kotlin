package br.com.liturgico.testandokotlin.controller

import br.com.liturgico.testandokotlin.dto.request.CreateOrganizationRequest
import br.com.liturgico.testandokotlin.dto.response.CreateOrganizationResponse
import br.com.liturgico.testandokotlin.entity.Organization
import br.com.liturgico.testandokotlin.service.OrganizationService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/v1/organizations")
class OrganizationController(val organizationService: OrganizationService) {
    @PostMapping
    @Transactional
    fun create(
        @RequestBody @Valid request: CreateOrganizationRequest,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<CreateOrganizationResponse> {
        var organization: Organization = this.organizationService.save(request.toEntity())
        var uri = uriComponentsBuilder.path("/api/v1/organizations/{id}").buildAndExpand(organization.id).toUri()
        return ResponseEntity.created(uri).body(CreateOrganizationResponse(organization))
    }


}