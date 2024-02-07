package br.com.liturgico.testandokotlin.service

import br.com.liturgico.testandokotlin.entity.Organization
import br.com.liturgico.testandokotlin.repository.OrganizationRepository
import org.springframework.stereotype.Service

@Service
class OrganizationService(val organizationRepository: OrganizationRepository) {
    fun save(organization: Organization): Organization = this.organizationRepository.save(organization)
}