package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.Member
import com.bssm.portfolio.repository.MemberRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class MemberServiceTest(
    private val memberRepository: MemberRepository,
) : BehaviorSpec({
    given("회원 생성시") {
        val member = Member.createAdmin("qkrwjdgh0904@naver.com", "1234", "박정호")
        `when`("회원 생성") {
            val savedMember = memberRepository.save(member)
            then("회원이 정상적으로 생성된다.") {
                savedMember.id shouldNotBe null
                memberRepository.findByIdOrNull(savedMember.id) shouldNotBe null
            }

            then("회원의 이름은 박정호이다.") {
                savedMember.name shouldBe "박정호"
            }
        }
    }
})
