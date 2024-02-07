package br.com.liturgico.testandokotlin.repository

import br.com.liturgico.testandokotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>