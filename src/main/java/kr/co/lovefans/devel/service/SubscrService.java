package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.dto.SubCreDto;
import kr.co.lovefans.devel.dto.SubsSubsListDto;
import kr.co.lovefans.devel.repository.SubCreRepository;
import kr.co.lovefans.devel.repository.SubsCustomRepository;
import kr.co.lovefans.devel.repository.SubscrRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class SubscrService {

    private final SubscrRepository subscrRepository;
    private final SubCreRepository subCreRepository;

    private final SubsCustomRepository subsCustomRepository;

    public SubscrService(SubscrRepository subscrRepository, SubCreRepository subCreRepository, SubsCustomRepository subsCustomRepository) {
        this.subscrRepository = subscrRepository;
        this.subCreRepository = subCreRepository;
        this.subsCustomRepository = subsCustomRepository;
    }

    public List<MemberDto> findAll() {
        return subscrRepository.findAll();
    }

    public List<SubCreDto> findCre() {
        return subCreRepository.findCre();
    }


    public List<SubsSubsListDto> findBySlVmiSeq(Long SlVmiSeq){

        return subsCustomRepository.findBySlVmiSeq(SlVmiSeq);
    }
}
