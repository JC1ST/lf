package kr.co.lovefans.devel.repository;

import com.querydsl.core.Tuple;
import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;
import java.util.Optional;


public interface CreatorRepository {

    CreatorInfoDto save(CreatorInfoDto creatorInfo);
    Optional<CreatorInfoDto> findBySeq(Long ciMiSeq);
    Optional<CreatorInfoDto> findByPageNm(String ciPageNm);
    Optional<MemberInfoDto> findMemInfoBySeq(Long miSeq);

    List<CreatorInfoDto> findAll();
    List<CreatorPostDto> findAllPost(Long cpMiSeq);
    List<MemberDto> findAllPlus();
}
