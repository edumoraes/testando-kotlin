package br.com.liturgico.testandokotlin.entity

import jakarta.persistence.*

@Embeddable
data class ProgramMeta(
    val title: String = "",
)
