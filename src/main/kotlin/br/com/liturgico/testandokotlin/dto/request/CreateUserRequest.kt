package br.com.liturgico.testandokotlin.dto.request

import br.com.liturgico.testandokotlin.entity.User
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:NotBlank(message = "Name is required") val name: String,
    @field:NotBlank(message = "Email is required") val email: String,
) {
    fun toEntity(): User = User(
        name = this.name,
        email = this.email

    )
}
