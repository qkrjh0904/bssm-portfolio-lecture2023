package com.bssm.portfolio.controller

import com.bssm.portfolio.controller.rs.FindPortfolioDetailRs
import com.bssm.portfolio.global.ApiPath
import com.bssm.portfolio.service.PortfolioReadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PortfolioController(
    private val portfolioReadService: PortfolioReadService,
) {

    @GetMapping(ApiPath.PORTFOLIO_V1_ID)
    fun findById(@PathVariable(value = "id") portfolioId: Long): FindPortfolioDetailRs {
        return portfolioReadService.findById(portfolioId)
    }

}
