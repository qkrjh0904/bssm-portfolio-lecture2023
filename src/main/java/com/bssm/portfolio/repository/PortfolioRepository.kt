package com.bssm.portfolio.repository

import com.bssm.portfolio.controller.rq.FindPortfolioRq
import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.domain.entity.QPortfolio.portfolio
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface PortfolioRepository : JpaRepository<Portfolio, Long>, CustomPortfolioRepository

interface CustomPortfolioRepository {
    fun findPageBy(page: Pageable, rq: FindPortfolioRq): Page<Portfolio>
}

class PortfolioRepositoryImpl : CustomPortfolioRepository, QuerydslRepositorySupport(Portfolio::class.java) {
    override fun findPageBy(pageRq: Pageable, rq: FindPortfolioRq): Page<Portfolio> {
        val result = from(portfolio)
            .where(
                rq.title?.let { portfolio.title.contains(it) }
            )
            .orderBy(portfolio.createdDateTime.desc())
            .offset(pageRq.offset)
            .limit(pageRq.pageSize.toLong())
            .fetchResults()
        return PageImpl(result.results, pageRq, result.total)
    }
}
