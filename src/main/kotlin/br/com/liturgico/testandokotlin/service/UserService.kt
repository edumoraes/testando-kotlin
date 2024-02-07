package br.com.liturgico.testandokotlin.service

import br.com.liturgico.testandokotlin.entity.User
import br.com.liturgico.testandokotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(user: User): User = this.userRepository.save(user)
    fun findById(id: Long): User {
        return this.userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
    }
}
