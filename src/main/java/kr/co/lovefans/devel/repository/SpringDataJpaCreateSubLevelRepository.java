package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorSubLevelDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaCreateSubLevelRepository extends JpaRepository<CreatorSubLevelDto,Long>, CreateSubLevelRepository {

    @Override
    List<CreatorSubLevelDto> findByCslMiSeq(Long CslMiSeq);

    @Override
    Optional<CreatorSubLevelDto> findByCslSeq(Long ScsSeq);


}

