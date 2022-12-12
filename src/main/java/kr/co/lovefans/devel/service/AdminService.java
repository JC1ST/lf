package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.repository.AdminRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Page<MemberInfoDto> findPage(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }
}
