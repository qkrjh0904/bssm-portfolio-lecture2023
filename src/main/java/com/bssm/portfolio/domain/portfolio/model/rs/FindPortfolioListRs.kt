package com.bssm.portfolio.domain.portfolio.model.rs

import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme

data class FindPortfolioListRs(
    val portfolioId: Long,
    val thumbnailUrl: String,
    val title: String,
    val createdDateTime: String,
    val writerName: String,
    val writerProfileImageUrl: String,
    val theme: PortfolioTheme,
    val protectType: PortfolioProtectType,
)
