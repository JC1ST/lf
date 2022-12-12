package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.dto.PostDto;

import java.util.List;

public interface SubsPostCustomRepository {

    List<PostDto> findBySlvmiSeq(Long slvmiseq);
}
