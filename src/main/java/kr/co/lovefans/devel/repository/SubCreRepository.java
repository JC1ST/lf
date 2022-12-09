package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.dto.SubCreDto;

import java.util.List;

public interface SubCreRepository {

    // 구독한 크리에이터
    List<SubCreDto> findCre(Long slvmiseq);
}
