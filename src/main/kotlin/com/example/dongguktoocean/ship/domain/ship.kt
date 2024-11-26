package com.example.dongguktoocean.ship.domain
import jakarta.persistence.*


@Entity
@Table(name = "ship")
data class Ship(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "ship_id")
    val ship_id: String,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "location")
    val location: String? = null,

    @Column(name = "ship_capacity")
    val ship_capacity: String? = null
)


