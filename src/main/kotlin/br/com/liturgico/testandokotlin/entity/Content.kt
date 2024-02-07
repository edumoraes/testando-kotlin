package br.com.liturgico.testandokotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "contents")
data class Content(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String = "",

    var subtitle: String = "",

    var content: String = "",

    @OneToMany(mappedBy = "content")
    var programs: Set<ContentsInPrograms> = mutableSetOf()
) {

    fun updateTitle(title: String) {
        this.title = title
    }

    fun updateSubtitle(subtitle: String) {
        this.subtitle = subtitle
    }

    fun updateContent(content: String) {
        this.content = content
    }
}