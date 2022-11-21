package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.SubListDto;
import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface SubscrRepository {

    List<MemberDto> findAll();

    List<SubListDto> findMySub(Long SlCMiSeq);
}
