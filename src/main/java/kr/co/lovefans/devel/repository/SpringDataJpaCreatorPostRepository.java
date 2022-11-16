package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.dto.PostDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataJpaCreatorPostRepository extends JpaRepository<CreatorPostDto,Long> , CreatorPostRepository {

    @Override
    CreatorPostDto save(CreatorPostDto creatorPostDto);

    @Override
    List<CreatorPostDto> findBycpMiSeq(Long cpMiSeq);



    @Override
    Slice<CreatorPostDto> findSliceBycpMiSeq(Long cpMiSeq, Pageable pageable);



}
