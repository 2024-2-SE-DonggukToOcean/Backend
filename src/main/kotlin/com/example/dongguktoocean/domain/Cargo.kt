package com.example.dongguktoocean.domain
import jakarta.persistence.*

@Entity
@Table(name = "Cargo")
data class Cargo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "doc_id")
    val invoiceDoc: InvoiceDoc, // 문서 ID (InvoiceDoc과 연관)

    @Column(nullable = false)
    val cargoQuantity: Int, // 화물 수량

    @Column(nullable = false)
    val cargoType: String, // 화물 종류

    @Column(nullable = false)
    val cargoWeight: Int // 화물 중량
)
