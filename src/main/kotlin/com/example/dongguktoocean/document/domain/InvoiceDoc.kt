package com.example.dongguktoocean.document.domain
import jakarta.persistence.*


@Entity
@Table(name = "Invoice_Doc")
data class InvoiceDoc(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val num: String, // 주문서 번호

    @Column(nullable = false)
    val name: String, // 상품명

    @Column(nullable = false)
    val cargoQuantity: Int, // 화물 수량

    @Column(nullable = false)
    val cargoType: String, // 화물 종류

    @Column(nullable = false)
    val cargoWeight: Int, // 화물 중량

    @Column(nullable = false)
    val price: Int, // 단가

    @Column(nullable = false)
    val ship: String, // 선박명

    @Column(nullable = false)
    val load_port: String, // 선적항

    @Column(nullable = false)
    val dest_port: String, // 목적항

    @Column(nullable = false)
    val sender: String, // 송신자

    @Column(nullable = false)
    val receiver: String // 수신자
)
