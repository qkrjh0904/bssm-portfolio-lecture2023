package com.bssm.portfolio.domain.portfolio.model.rq

import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme

data class PortfolioUpdateRq(
    val title: String,
    val description: String?,
    val theme: PortfolioTheme,
    val webUrl: String?,
    val gitUrl: String?,
    val protectType: PortfolioProtectType,
    val contributorIdList: List<Long>?,
    val updatedBy: Long,
)
