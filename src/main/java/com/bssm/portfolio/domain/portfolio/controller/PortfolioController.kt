package com.bssm.portfolio.domain.portfolio.controller

import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioDeleteRq
import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioSaveRq
import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioUpdateRq
import com.bssm.portfolio.global.ApiPath
import org.springframework.web.bind.annotation.*

@RestController
class PortfolioController {

    @PostMapping(ApiPath.PORTFOLIO_V1)
    fun savePortfolio(
        @RequestBody rq: PortfolioSaveRq,
    ): Long {
        return 1L
    }

    @PutMapping(ApiPath.PORTFOLIO_V1_ID)
    fun updatePortfolio(
        @PathVariable id: Long,
        @RequestBody rq: PortfolioUpdateRq,
    ): Long {
        return id
    }

    @DeleteMapping(ApiPath.PORTFOLIO_V1_ID)
    fun deletePortfolio(
        @PathVariable id: Long,
        @RequestBody rq: PortfolioDeleteRq,
    ): Long {
        return id
    }
}
