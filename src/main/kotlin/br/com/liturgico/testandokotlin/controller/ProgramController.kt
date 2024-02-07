package br.com.liturgico.testandokotlin.controller

import br.com.liturgico.testandokotlin.dto.request.CreateProgramRequest
import br.com.liturgico.testandokotlin.dto.response.CreateProgramResponse
import br.com.liturgico.testandokotlin.service.ProgramService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/v1/programs")
class ProgramController(val programService: ProgramService) {
    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid request: CreateProgramRequest, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<CreateProgramResponse> {
        val program = this.programService.save(request.toEntity())
        val uri = uriComponentsBuilder.path("/api/v1/programs/{id}").buildAndExpand(program.id).toUri()
        return ResponseEntity.created(uri).body(CreateProgramResponse(program))
    }
}