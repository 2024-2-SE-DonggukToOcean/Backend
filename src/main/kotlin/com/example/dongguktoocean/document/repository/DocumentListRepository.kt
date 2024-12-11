package com.example.dongguktoocean.document.repository

import com.example.dongguktoocean.document.domain.DocumentList
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentListRepository : JpaRepository<DocumentList, Long>{
        fun findByBlDocId(blDocId: Long): DocumentList?

}