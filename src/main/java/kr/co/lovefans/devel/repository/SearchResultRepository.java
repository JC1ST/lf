package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface SearchResultRepository {

    Page<CreatorInfoDto> findByciPageNmContainingIgnoreCase(String ciPageNm, Pageable pageable);
}