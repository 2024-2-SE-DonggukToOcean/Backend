package com.example.dongguktoocean.container.domain
import com.example.dongguktoocean.ship.domain.Ship
import jakarta.persistence.*


@Entity
@Table(name = "container")
data class Container(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "field", nullable = false)
    val field: String,

    @Column(name = "field2", nullable = true)
    val field2: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship", foreignKey = ForeignKey(name = "fk_container_ship"))
    val ship: Ship
)