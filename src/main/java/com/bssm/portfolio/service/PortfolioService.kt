package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.AttachFile
import com.bssm.portfolio.domain.entity.Member
import com.bssm.portfolio.repository.MemberRepository
import com.bssm.portfolio.repository.PortfolioRepository
import com.bssm.portfolio.service.dto.PortfolioCreateDto
import com.bssm.portfolio.service.dto.toEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PortfolioService(
    private val portfolioRepository: PortfolioRepository,
    private val attachFileRepository: AttachFileRepository,
    private val memberRepository: MemberRepository,
) {
    fun create(dto: PortfolioCreateDto): Long {
        val videoFile = AttachFile.create(dto.videoFileUid, "파일경로", "영상", 1L)
        val thumbnailFile = AttachFile.create(dto.thumbnailFileUid, "파일경로", "썸네일", 1L)
        attachFileRepository.save(videoFile)
        attachFileRepository.save(thumbnailFile)

        val member = Member.createAdmin("qkrwjdgh0904@naver.com", "1234", "박정호")
        memberRepository.save(member)

        return portfolioRepository.save(dto.toEntity(videoFile, thumbnailFile, member)).id
    }
}
