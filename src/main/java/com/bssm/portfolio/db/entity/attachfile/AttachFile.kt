package com.bssm.portfolio.db.entity.attachfile

import com.bssm.portfolio.db.entity.BaseDateTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class AttachFile(
    fileUid: String,
    filePath: String,
    fileName: String,
    fileSize: Long,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(nullable = false)
    var fileUid: String = fileUid

    @Column(nullable = false)
    var filePath: String = filePath

    @Column(nullable = false)
    var fileName: String = fileName

    @Column(nullable = false)
    var fileSize: Long = fileSize
}
