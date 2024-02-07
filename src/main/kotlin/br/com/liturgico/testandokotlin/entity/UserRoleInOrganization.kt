package br.com.liturgico.testandokotlin.entity

import br.com.liturgico.testandokotlin.enummeration.Role
import jakarta.persistence.*

@Entity
@Table(name = "user_roles_in_organizations")
data class UserRoleInOrganization(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    val organization: Organization,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    var role: Role
) {
    public fun updateRole(role: Role) {
        this.role = role
    }
}
