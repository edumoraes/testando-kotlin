package br.com.liturgico.testandokotlin.repository

import br.com.liturgico.testandokotlin.entity.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface OrganizationRepository : JpaRepository<Organization, Long>