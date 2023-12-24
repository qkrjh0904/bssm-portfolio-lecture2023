package com.bssm.portfolio.domain.portfolio.controller

import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioDeleteRq
import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioSaveRq
import com.bssm.portfolio.domain.portfolio.model.rq.PortfolioUpdateRq
import com.bssm.portfolio.global.ApiPath
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PortfolioWriteController {

    @PostMapping(ApiPath.PORTFOLIO_V1)
    fun savePortfolio(
        @RequestBody rq: PortfolioSaveRq,
    ): Long {
        return 1L
    }

    @PutMapping(ApiPath.PORTFOLIO_V1_ID)
    fun updatePortfolio(
        @PathVariable(value = "id") portfolioId: Long,
        @RequestBody rq: PortfolioUpdateRq,
    ): Long {
        return portfolioId
    }

    @DeleteMapping(ApiPath.PORTFOLIO_V1_ID)
    fun deletePortfolio(
        @PathVariable(value = "id") portfolioId: Long,
        @RequestBody rq: PortfolioDeleteRq,
    ): Long {
        return portfolioId
    }
}
