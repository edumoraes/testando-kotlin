package br.com.liturgico.testandokotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "organizations")
data class Organization(
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @OneToMany(mappedBy = "organization")
    var users: Set<UserRoleInOrganization> = mutableSetOf(),

    @OneToMany(mappedBy = "organization")
    var program: List<Program> = mutableListOf()
) {
constructor() : this(id = null, name = "")
}