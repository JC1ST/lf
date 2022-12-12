package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.dto.SubsSubsListDto;

import java.util.List;

public interface SubsCustomRepository {

    List<SubsSubsListDto> findBySlVmiSeq(Long SlVmiSeq);

}
