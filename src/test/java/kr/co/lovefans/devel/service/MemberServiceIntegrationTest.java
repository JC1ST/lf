package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.repository.MemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {


    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {

        //given
        Member member = new Member();
        member.setMiId("abc3333@test.com");
        member.setMiPwd("");
        member.setMiNick("e");



        //when
        Long saveSeq = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveSeq).get();
        assertThat(member.getMiId()).isEqualTo(findMember.getMiId());

    }


    @Test
    public void 중복_예외(){
        //given
        Member member1 = new Member();
        member1.setMiId("mail@mail.com");
        member1.setMiPwd("test1");
        member1.setMiNick("tester1");

        Member member2 = new Member();
        member2.setMiId("mail@mail.com");
        member2.setMiPwd("test");
        member2.setMiNick("tester2");
        //when

        memberService.join(member1);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 가입된 메일입니다.");
    }


    @Test
    public void login(){
        Member member1 = new Member();
        member1.setMiId("test2@test.com");
        member1.setMiPwd("12345");

        boolean check = memberService.login(member1);
        System.out.println(check);

    }



    @Test
    void findOne() {

    }
}