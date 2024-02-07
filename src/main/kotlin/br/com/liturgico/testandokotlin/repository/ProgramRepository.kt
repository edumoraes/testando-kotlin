package br.com.liturgico.testandokotlin.repository

import br.com.liturgico.testandokotlin.entity.Program
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramRepository : JpaRepository<Program, Long>