package com.bssm.portfolio.service.dto

import com.bssm.portfolio.domain.entity.AttachFile
import com.bssm.portfolio.domain.entity.Member
import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioTheme

data class PortfolioCreateDto(
    val title: String,
    val description: String,
    val theme: PortfolioTheme,
    val webUrl: String,
    val gitUrl: String,
    val protectType: PortfolioProtectType,
    val videoFileUid: String,
    val thumbnailFileUid: String,
    val memberId: Long,
)

fun PortfolioCreateDto.toEntity(
    videoFile: AttachFile,
    thumbnailFile: AttachFile,
    member: Member,
): Portfolio {
    return Portfolio.create(
        title = title,
        description = description,
        theme = theme,
        webUrl = webUrl,
        gitUrl = gitUrl,
        protectType = protectType,
        videoFile = videoFile,
        thumbnailFile = thumbnailFile,
        member = member,
    )
}
