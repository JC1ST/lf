package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.SubListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpringDataJpaSubListRepository extends  JpaRepository<SubListDto,Long> , SubListRepository {

    @Query("select m from SubListDto m where m.subListDtoId.slCMiSeq = ?1 and m.subListDtoId.slVMiSeq = ?2")
    @Override
    Optional<SubListDto> checkBySeq(Long cSeq, Long vSeq);

    @Query("select count(m) from SubListDto m where m.subListDtoId.slCMiSeq = ?1")
    @Override
    Long countBySlCMiSeq(Long seq);

}