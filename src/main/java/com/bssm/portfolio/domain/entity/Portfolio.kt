package com.bssm.portfolio.domain.entity

import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioTheme
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Portfolio private constructor(
    title: String,
    description: String,
    theme: PortfolioTheme,
    webUrl: String,
    gitUrl: String,
    protectType: PortfolioProtectType,
    videoFile: AttachFile,
    thumbnailFile: AttachFile,
    member: Member,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var title: String = title

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var theme: PortfolioTheme = theme

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var protectType: PortfolioProtectType = protectType

    var description: String = description

    var webUrl: String = webUrl

    var gitUrl: String = gitUrl

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "video_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_VIDEO_ATTACH_FILE_ID")
    )
    var videoFile: AttachFile = videoFile
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "thumbnail_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_THUMBNAIL_ATTACH_FILE_ID")
    )
    var thumbnailFile: AttachFile = thumbnailFile
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "member_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_MEMBER_ID")
    )
    var member: Member = member
        private set

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contributorList: List<PortfolioContributor> = mutableListOf()
        protected set

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentList: List<Comment> = mutableListOf()
        protected set

    companion object {
        fun create(
            title: String,
            description: String,
            theme: PortfolioTheme,
            webUrl: String,
            gitUrl: String,
            protectType: PortfolioProtectType,
            videoFile: AttachFile,
            thumbnailFile: AttachFile,
            member: Member,
        ): Portfolio {
            return Portfolio(
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
    }
}
