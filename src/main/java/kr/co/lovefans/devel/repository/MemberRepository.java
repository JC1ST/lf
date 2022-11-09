package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {


    Member save(Member member);
    Optional<Member> findByMiSeq(Long mi_seq);
    Optional<Member> findByMiId(String mi_id);

    Optional<Member> findByMiNick(String mi_nick);
    List<Member> findAll();
}
