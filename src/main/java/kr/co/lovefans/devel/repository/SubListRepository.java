package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.SubListDto;

import java.util.List;
import java.util.Optional;

public interface SubListRepository {

    SubListDto save(SubListDto subListDto);

    Optional<SubListDto> checkBySeq(Long cSeq, Long vSeq);

    List<SubListDto> findAll();

    void delete(SubListDto subListDto);


    Long countBySlCMiSeq(Long seq);




}

