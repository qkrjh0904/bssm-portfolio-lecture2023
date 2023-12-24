package com.bssm.portfolio.domain.portfolio.model.rs

import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme
import java.time.LocalDateTime

data class FindDetailPortfolioRs(
    val portfolioId: Long,
    val videoUrl: String,
    val thumbnailUrl: String,
    val title: String,
    val theme: PortfolioTheme,
    val protectType: PortfolioProtectType,
    val webUrl: String,
    val description: String,
    val contributorIdList: List<Long>,
    val gitUrl: String,
    val createdDateTime: LocalDateTime,
    val writerName: String,
    val writerProfileImageUrl: String,
)
