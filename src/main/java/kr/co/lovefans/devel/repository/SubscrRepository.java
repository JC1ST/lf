package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.SubListDto;
import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface SubscrRepository {


    // 비구독 크리에이터
    List<MemberDto> findAll(Long slvmiseq);

    List<SubListDto> findMySub(Long SlCMiSeq);

}
