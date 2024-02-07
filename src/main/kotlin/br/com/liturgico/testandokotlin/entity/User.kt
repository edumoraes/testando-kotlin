package br.com.liturgico.testandokotlin.entity

import br.com.liturgico.testandokotlin.enummeration.Role
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @OneToMany(mappedBy = "user")
    var organizations: Set<UserRoleInOrganization> = mutableSetOf()
) {
    public fun updateName(name: String) {
        this.name = name
    }
    public fun updateEmail(email: String) {
        this.email = email
    }
    public fun addOrganization(organization: Organization, role: Role) {
        val userRoleInOrganization = UserRoleInOrganization(
            organization = organization,
            user = this,
            role = role
        )
        this.organizations = this.organizations.plus(userRoleInOrganization)
    }
}

