package com.bssm.portfolio.db.entity.portfolio

import com.bssm.portfolio.db.entity.BaseDateTime
import com.bssm.portfolio.db.entity.member.Member
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class PortfolioContributor(
    portfolio: Portfolio,
    member: Member,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "portfolio_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_CONTRIBUTOR_PORTFOLIO_ID")
    )
    var portfolio: Portfolio = portfolio
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "member_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_CONTRIBUTOR_MEMBER_ID")
    )
    var member: Member = member
        private set
}
