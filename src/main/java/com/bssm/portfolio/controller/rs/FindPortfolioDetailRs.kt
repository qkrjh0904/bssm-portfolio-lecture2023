package com.bssm.portfolio.controller.rs

import com.bssm.portfolio.domain.entity.Portfolio

data class FindPortfolioDetailRs(
    val id: Long,
    val title: String,
)

fun Portfolio.toFindPortfolioDetailRs() = FindPortfolioDetailRs(
    id = id,
    title = title,
)
