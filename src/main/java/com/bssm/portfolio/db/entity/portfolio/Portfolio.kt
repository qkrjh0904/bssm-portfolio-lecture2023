package com.bssm.portfolio.db.entity.portfolio

import com.bssm.portfolio.db.entity.BaseDateTime
import com.bssm.portfolio.db.entity.attachfile.AttachFile
import com.bssm.portfolio.db.entity.member.Member
import com.bssm.portfolio.db.enums.PortfolioProtectType
import com.bssm.portfolio.db.enums.PortfolioTheme
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
class Portfolio(
    title: String,
    description: String,
    theme: PortfolioTheme,
    webUrl: String,
    gitUrl: String,
    protectType: PortfolioProtectType,
    videoAttachFile: AttachFile,
    thumbnailAttachFile: AttachFile,
    member: Member,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

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
        name = "video_attach_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_VIDEO_ATTACH_FILE_ID")
    )
    var videoAttachFile: AttachFile = videoAttachFile
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "thumbnail_attach_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_THUMBNAIL_ATTACH_FILE_ID")
    )
    var thumbnailAttachFile: AttachFile = thumbnailAttachFile
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
}
