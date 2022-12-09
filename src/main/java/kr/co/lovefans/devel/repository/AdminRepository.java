package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.MemberInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminRepository {

    Page<MemberInfoDto> findAll(Pageable pageable);

}
