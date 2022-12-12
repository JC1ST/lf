package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface SubscrRepository {

    Subscr save(Subscr subscr);

    // 비구독 크리에이터
    List<MemberDto> findAll(Long slvmiseq);

    List<SubListTempDto> findMySub(Long SlCMiSeq);

    // 내 구독자 조회
    List<MemberDto> findSub(Long slcMiSeq);
}
