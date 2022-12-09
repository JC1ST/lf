package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaSearchResultRepository extends JpaRepository<CreatorInfoDto,Long>, SearchResultRepository {

    @Override
    Page<CreatorInfoDto> findByciPageNmContainingIgnoreCase(String ciPageNm, Pageable pageable);
}