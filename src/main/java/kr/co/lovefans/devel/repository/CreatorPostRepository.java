package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.CreatorPostDto;
import kr.co.lovefans.devel.dto.PostDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CreatorPostRepository {

    CreatorPostDto save(CreatorPostDto creatorPostDto);

    List<CreatorPostDto> findBycpMiSeq(Long cpMiSeq);

    Slice<CreatorPostDto> findSliceBycpMiSeq(Long cpMiSeq, Pageable pageable);



}
