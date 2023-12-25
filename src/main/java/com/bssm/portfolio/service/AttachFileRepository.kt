package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.AttachFile
import org.springframework.data.jpa.repository.JpaRepository

interface AttachFileRepository : JpaRepository<AttachFile, Long> {
}
