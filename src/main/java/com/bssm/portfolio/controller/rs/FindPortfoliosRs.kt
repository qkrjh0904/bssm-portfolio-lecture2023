package com.bssm.portfolio.controller.rs

import com.bssm.portfolio.domain.entity.Portfolio
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

data class FindPortfoliosRs(
    val id: Long,
    val title: String,
)

fun Page<Portfolio>.toFindPortfoliosRs() = PageImpl(
    this.content.map { it.toFindPortfoliosRs() },
    this.pageable,
    this.totalElements
)

fun Portfolio.toFindPortfoliosRs() = FindPortfoliosRs(
    id = id,
    title = title,
)
