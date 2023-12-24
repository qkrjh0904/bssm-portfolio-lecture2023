package com.bssm.portfolio.domain.portfolio.controller

import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme
import com.bssm.portfolio.domain.portfolio.model.rq.FindPortfolioListRq
import com.bssm.portfolio.domain.portfolio.model.rs.FindDetailPortfolioRs
import com.bssm.portfolio.domain.portfolio.model.rs.FindPortfolioListRs
import com.bssm.portfolio.global.ApiPath
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class PortfolioReadController {

    @GetMapping(ApiPath.PORTFOLIO_V1_ID)
    fun findDetailPortfolio(
        @PathVariable id: Long,
    ): FindDetailPortfolioRs {
        return FindDetailPortfolioRs(
            1,
            "videoUrl",
            "thumbnailUrl",
            "title",
            PortfolioTheme.WEB,
            PortfolioProtectType.PUBLIC,
            "webUrl",
            "description",
            listOf(2, 3),
            "gitUrl",
            LocalDateTime.now(),
            "writerName",
            "writerProfileImageUrl"
        )
    }

    @GetMapping(ApiPath.PORTFOLIO_V1)
    fun findPortfolioList(
        pageable: Pageable,
        rq: FindPortfolioListRq,
    ): Page<FindPortfolioListRs> {
        return Page.empty()
    }
}
