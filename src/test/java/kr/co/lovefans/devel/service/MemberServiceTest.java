//package kr.co.lovefans.devel.service;
//
//import kr.co.lovefans.devel.domain.Member;
//import kr.co.lovefans.devel.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.*;
//
//class MemberServiceTest {
//
//
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    @AfterEach
//    public void afterEach(){
//        memberRepository.clearStore();
//    }
//
//    @BeforeEach
//    public void beforeEach(){
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @Test
//    void join() {
//
//        //given
//        Member member = new Member();
//        member.setMi_id("test@mail.mail");
//
//        //when
//        Long saveSeq = memberService.join(member);
//        //then
//        Member findMember = memberService.findOne(saveSeq).get();
//        assertThat(member.getMi_id()).isEqualTo(findMember.getMi_id());
//    }
//
//
//    @Test
//    public void 중복_예외(){
//        //given
//        Member member1 = new Member();
//        member1.setMi_id("mail@mail.com");
//
//        Member member2 = new Member();
//        member2.setMi_id("mail@mail.com");
//        //when
//
//        memberService.join(member1);
//        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThat(e.getMessage()).isEqualTo("이미 가입된 메일입니다.");
////        try{
////            memberService.join(member2);
////            fail("ㅛ");
////        }catch (IllegalStateException e){
////            assertThat(e.getMessage()).isEqualTo("이미 가입된 메일입니다.");
////        }
//
//
//
//        //then
//    }
//
//
//
//
//    @Test
//    void findOne() {
//
//    }
//}