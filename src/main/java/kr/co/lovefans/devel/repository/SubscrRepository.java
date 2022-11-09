package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.dto.MemberDto;

import java.util.List;

public interface SubscrRepository {

    List<MemberDto> findAll();
}
