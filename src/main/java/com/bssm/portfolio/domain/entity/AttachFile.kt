package com.bssm.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class AttachFile private constructor(
    fileUid: String,
    filePath: String,
    fileName: String,
    fileSize: Long,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var fileUid: String = fileUid

    @Column(nullable = false)
    var filePath: String = filePath

    @Column(nullable = false)
    var fileName: String = fileName

    @Column(nullable = false)
    var fileSize: Long = fileSize

    companion object {
        fun create(
            fileUid: String,
            filePath: String,
            fileName: String,
            fileSize: Long,
        ): AttachFile {
            return AttachFile(
                fileUid = fileUid,
                filePath = filePath,
                fileName = fileName,
                fileSize = fileSize,
            )
        }
    }
}
