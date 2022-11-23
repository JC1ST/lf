package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;

public interface SubscrRepository {

    // 비구독 크리에이터
    List<MemberDto> findAll(Long slvmiseq);
}
