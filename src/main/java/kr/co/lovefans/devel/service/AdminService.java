package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.repository.AdminRepository;

import java.util.List;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public List<MemberInfoDto> findAll() {
        return adminRepository.findAll();
    }
}
