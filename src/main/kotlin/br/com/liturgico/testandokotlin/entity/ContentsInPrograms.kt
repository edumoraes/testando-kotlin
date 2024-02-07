package br.com.liturgico.testandokotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "contents_in_programs")
data class ContentsInPrograms(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "program_id")
    val program: Program,

    @ManyToOne
    @JoinColumn(name = "content_id")
    val content: Content,

    @Column(name = "position")
    var position: Int = 0,
) {
    fun updatePosition(position: Int) {
        this.position = position
    }
}
