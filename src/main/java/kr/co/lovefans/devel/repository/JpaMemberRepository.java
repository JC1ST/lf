//package kr.co.lovefans.devel.repository;
//
//import kr.co.lovefans.devel.domain.Member;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//public class JpaMemberRepository implements MemberRepository{
//
//    private final EntityManager em;
//
//    public JpaMemberRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public Member save(Member member) {
//
//        em.persist(member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findBySeq(Long mi_seq) {
//        Member member = em.find(Member.class, mi_seq);
//        return Optional.ofNullable(member);
//    }
//
//    @Override
//    public Optional<Member> findById(String mi_id) {
//        List<Member> result = em.createQuery("select m from Member m where m.mi_id = :mi_id", Member.class)
//                .setParameter("mi_id", mi_id)
//                .getResultList();
//
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findByNick(String mi_nick) {
//
//        List<Member> result = em.createQuery("select m from Member m where m.mi_nick = :mi_nick", Member.class)
//                .setParameter("mi_nick", mi_nick)
//                .getResultList();
//
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return em.createQuery("select m from Member m",Member.class).getResultList();
//    }
//}
