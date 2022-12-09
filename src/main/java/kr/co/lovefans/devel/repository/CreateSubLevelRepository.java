package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorSubLevelDto;

import java.util.List;
import java.util.Optional;

public interface CreateSubLevelRepository {

    List<CreatorSubLevelDto> findByCslMiSeq(Long CslMiSeq);
    Optional<CreatorSubLevelDto> findByCslSeq(Long ScsSeq);

}

