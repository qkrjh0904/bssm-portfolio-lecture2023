package com.bssm.portfolio.domain.portfolio.model.rq

import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme
import org.springframework.web.bind.annotation.RequestParam

data class FindPortfolioListRq(
    @RequestParam(required = false)
    val theme: PortfolioTheme?,
    @RequestParam(required = false)
    val protectType: PortfolioProtectType?,
    @RequestParam(required = false)
    val name: String?,
    @RequestParam(required = false)
    val title: String?,
)
