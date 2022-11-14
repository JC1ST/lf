package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.MemberInfoDto;

import java.util.List;

public interface AdminRepository {

    List<MemberInfoDto> findAll();

}
