package com.bssm.portfolio.db.entity.member

import com.bssm.portfolio.db.entity.BaseDateTime
import com.bssm.portfolio.db.entity.portfolio.Portfolio
import com.bssm.portfolio.db.entity.portfolio.PortfolioContributor
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Member(
    email: String,
    password: String,
    name: String,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(nullable = false)
    var email: String = email

    @Column(nullable = false)
    var password: String = password

    @Column(nullable = false)
    var name: String = name

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    var portfolioList: List<Portfolio> = mutableListOf()

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contributorList: List<PortfolioContributor> = mutableListOf()
}
