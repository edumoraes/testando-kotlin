package br.com.liturgico.testandokotlin.dto.response

import br.com.liturgico.testandokotlin.entity.User

data class CreateUserResponse(
    val id: Long?,
    val name: String,
    val email: String
) {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        email = user.email)
}
