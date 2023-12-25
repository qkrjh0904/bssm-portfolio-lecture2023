package com.bssm.portfolio.service

import com.bssm.portfolio.controller.rq.FindPortfolioRq
import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioTheme
import com.bssm.portfolio.repository.PortfolioRepository
import com.bssm.portfolio.service.dto.PortfolioCreateDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class PortfolioServiceTest(
    private val portfolioRepository: PortfolioRepository,

    private val portfolioService: PortfolioService,
    private val portfolioReadService: PortfolioReadService,
) : BehaviorSpec({
    beforeSpec {
        // before spec
        portfolioService.create(
            PortfolioCreateDto(
                "제목1",
                "설명",
                PortfolioTheme.WEB,
                "웹주소",
                "깃주소",
                PortfolioProtectType.PUBLIC,
                "videoFileUid",
                "thumbnailFileUid",
                1L
            )
        )
        portfolioService.create(
            PortfolioCreateDto(
                "제목2",
                "설명",
                PortfolioTheme.WEB,
                "웹주소",
                "깃주소",
                PortfolioProtectType.PUBLIC,
                "videoFileUid",
                "thumbnailFileUid",
                1L
            )
        )
        portfolioService.create(
            PortfolioCreateDto(
                "제목3",
                "설명",
                PortfolioTheme.WEB,
                "웹주소",
                "깃주소",
                PortfolioProtectType.PUBLIC,
                "videoFileUid",
                "thumbnailFileUid",
                1L
            )
        )
        portfolioService.create(
            PortfolioCreateDto(
                "제목4",
                "설명",
                PortfolioTheme.WEB,
                "웹주소",
                "깃주소",
                PortfolioProtectType.PUBLIC,
                "videoFileUid",
                "thumbnailFileUid",
                1L
            )
        )
    }

    given("포트폴리오 생성시") {
        `when`("포트폴리오 생성") {
            val portfolioId = portfolioService.create(
                PortfolioCreateDto(
                    "제목",
                    "설명",
                    PortfolioTheme.WEB,
                    "웹주소",
                    "깃주소",
                    PortfolioProtectType.PUBLIC,
                    "videoFileUid",
                    "thumbnailFileUid",
                    1L
                )
            )

            then("포트폴리오가 정상적으로 생성된다.") {
                portfolioId shouldBeGreaterThan 0
                portfolioRepository.findByIdOrNull(portfolioId) shouldNotBe null
            }
        }
    }

    given("포트폴리오 상세 조회") {
        val portfolioId = 1L
        `when`("포트폴리오 상세 조회") {
            val portfolio = portfolioReadService.findById(portfolioId)

            then("포트폴리오 상세 조회") {
                portfolio.id shouldBe portfolioId
            }
        }
    }

    given("포트폴리오 목록 조회") {
        `when`("포트폴리오 목록 조회") {
            val portfolios = portfolioReadService.findPageBy(PageRequest.of(0, 3), FindPortfolioRq(null))
            then("포트폴리오 목록 조회") {
                portfolios.number shouldBe 0
                portfolios.size shouldBeGreaterThan 0
                portfolios.content.size shouldBe 3
                portfolios.content[0].id shouldBeGreaterThan 0
                portfolios.content[0].title shouldContain "제목"
            }
        }

        `when`("포트폴리오 제목으로 검색") {
            val portfolios = portfolioReadService.findPageBy(PageRequest.of(0, 10), FindPortfolioRq("제목4"))
            then("포트폴리오 목록 조회") {
                portfolios.number shouldBe 0
                portfolios.size shouldBeGreaterThan 0
                portfolios.content.size shouldBe 1
                portfolios.content[0].id shouldBeGreaterThan 0
                portfolios.content[0].title shouldContain "제목4"
            }
        }
    }
})
