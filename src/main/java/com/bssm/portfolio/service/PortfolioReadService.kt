package com.bssm.portfolio.service

import com.bssm.portfolio.controller.rq.FindPortfolioRq
import com.bssm.portfolio.controller.rs.FindPortfolioDetailRs
import com.bssm.portfolio.controller.rs.FindPortfoliosRs
import com.bssm.portfolio.controller.rs.toFindPortfolioDetailRs
import com.bssm.portfolio.controller.rs.toFindPortfoliosRs
import com.bssm.portfolio.repository.PortfolioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PortfolioReadService(
    private val portfolioRepository: PortfolioRepository,
) {

    fun findById(id: Long): FindPortfolioDetailRs {
        return portfolioRepository.findByIdOrNull(id)?.toFindPortfolioDetailRs()
            ?: throw IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다.")
    }

    fun findPageBy(pageRq: Pageable, rq: FindPortfolioRq): Page<FindPortfoliosRs> {
        return portfolioRepository.findPageBy(pageRq, rq).toFindPortfoliosRs()
    }


}
