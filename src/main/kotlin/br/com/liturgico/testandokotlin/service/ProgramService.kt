package br.com.liturgico.testandokotlin.service

import br.com.liturgico.testandokotlin.entity.Program
import br.com.liturgico.testandokotlin.repository.ProgramRepository
import org.springframework.stereotype.Service

@Service
class ProgramService(val programRepository: ProgramRepository) {
    fun save(program: Program): Program = this.programRepository.save(program)
}