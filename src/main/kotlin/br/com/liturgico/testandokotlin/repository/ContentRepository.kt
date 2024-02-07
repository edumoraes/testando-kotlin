package br.com.liturgico.testandokotlin.repository

import br.com.liturgico.testandokotlin.entity.Content
import org.springframework.data.jpa.repository.JpaRepository

interface ContentRepository : JpaRepository<Content, Long>