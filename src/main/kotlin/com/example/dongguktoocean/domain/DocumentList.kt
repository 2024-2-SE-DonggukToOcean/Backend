package com.example.dongguktoocean.domain

import jakarta.persistence.*

@Entity
@Table(name = "Document_List")
data class DocumentList(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User, // 유저 ID

    @OneToOne
    @JoinColumn(name = "inv_id")
    val invoiceDoc: InvoiceDoc?, // 상업송장 ID (nullable)

    @OneToOne
    @JoinColumn(name = "bl_id")
    val blDoc: BLDoc?, // 선하증권 ID (nullable)

    @Column(nullable = false)
    val status: String // 상태
)
