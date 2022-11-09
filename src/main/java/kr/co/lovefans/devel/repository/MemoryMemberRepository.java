//package kr.co.lovefans.devel.repository;
//
//import kr.co.lovefans.devel.domain.Member;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class MemoryMemberRepository implements MemberRepository{
//
//    private static Map<Long,Member> store = new HashMap<>();
//
//    private static long sequence = 0L;
//
//
//    @Override
//    public Member save(Member member) {
//
//        member.setMi_seq(++sequence);
//
//        store.put(member.getMi_seq(),member);
//
//
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findBySeq(Long mi_seq) {
//        return Optional.ofNullable(store.get(mi_seq));
//    }
//
//    @Override
//    public Optional<Member> findById(String mi_id) {
//        return store.values().stream().filter(member -> member.getMi_id().equals(mi_id)).findAny();
//    }
//
//    @Override
//    public Optional<Member> findByNick(String mi_nick) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return null;
//    }
//
//    public void clearStore(){
//        store.clear();
//    }
//}
