package br.com.liturgico.testandokotlin.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "programs")
data class Program(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "is_public", nullable = false)
    val isPublic: Boolean,

    @Embedded
    val metadata: ProgramMeta,

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    val organization: Organization,

    @OneToMany(mappedBy = "program")
    var contents: Set<ContentsInPrograms> = mutableSetOf(),

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime
) {
    fun addContent(content: Content, position: Int) {
        val enrollment = ContentsInPrograms(program = this, content = content, position = position)
        contents = contents.plus(enrollment)
    }
    fun updatePosition(content: Content, position: Int) {
        val enrollment = contents.find { it.content == content }
        enrollment?.updatePosition(position)
    }

    constructor(
        isPublic: Boolean,
        metadata: ProgramMeta,
    ) : this(
        isPublic = isPublic,
        metadata = metadata,
        organization = Organization(),
        updatedAt = LocalDateTime.now()
    )
}
