//package kr.co.lovefans.devel.repository;
//
//import kr.co.lovefans.devel.domain.Member;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//
//class MemoryMemberRepositoryTest {
//
//    MemberRepository repository = new MemoryMemberRepository();
//
//    @Test
//    public void save(){
//        Member member = new Member();
//        member.setMi_nick("tester");
//        member.setMi_id("test100@mail.com");
//        repository.save(member);
//
//        Member result = repository.findBySeq(member.getMi_seq()).get();
//        assertThat(member).isEqualTo(result);
//
//    }
//
//    @Test
//    public void findById(){
//        Member member1 = new Member();
//        member1.setMi_id("Test@mail.co.kr");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setMi_id("Test2@mail.co.kr");
//        repository.save(member2);
//
//       Member result = repository.findById("Test@mail.co.kr").get();
//
//       assertThat(result).isEqualTo(member1);
//    }
//}
