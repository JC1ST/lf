package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.SubListDto;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.dto.SubCreDto;
import kr.co.lovefans.devel.repository.SubCreRepository;
import kr.co.lovefans.devel.repository.SubscrRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SubscrService {

    private final SubscrRepository subscrRepository;
    private final SubCreRepository subCreRepository;

    public SubscrService(SubscrRepository subscrRepository, SubCreRepository subCreRepository) {
        this.subscrRepository = subscrRepository;
        this.subCreRepository = subCreRepository;
    }

    // 비구독 크리에이터
    public List<MemberDto> findAll(Long slvmiseq) {
        return subscrRepository.findAll(slvmiseq);
    }

    // 구독한 크리에이터
    public List<SubCreDto> findCre(Long slvmiseq) {
        return subCreRepository.findCre(slvmiseq);
    }

    public List<SubListDto> findSubBySlCMiSeq(Long slCMiSeq) {
        return subscrRepository.findMySub(slCMiSeq);
    }
}
