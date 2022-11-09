package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository {


    @Override
    Optional<Member> findByMiId(String mi_id);

    @Override
    Optional<Member> findByMiNick(String mi_nick);

    @Override
    Optional<Member> findByMiSeq(Long mi_seq);


}
