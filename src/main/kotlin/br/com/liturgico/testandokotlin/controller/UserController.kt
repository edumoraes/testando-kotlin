package br.com.liturgico.testandokotlin.controller

import br.com.liturgico.testandokotlin.dto.request.CreateUserRequest
import br.com.liturgico.testandokotlin.dto.response.CreateUserResponse
import br.com.liturgico.testandokotlin.entity.User
import br.com.liturgico.testandokotlin.service.UserService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/v1/users")
class UserController(private val userService: UserService) {
    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid request: CreateUserRequest, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<CreateUserResponse> {
        val user: User = this.userService.save(request.toEntity())
        val uri = uriComponentsBuilder.path("/api/v1/users/{id}").buildAndExpand(user.id).toUri()
        return ResponseEntity.created(uri).body(CreateUserResponse(user))
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): ResponseEntity<User> {
        val user: User = this.userService.findById(id)
        return ResponseEntity.ok(user)
    }
}