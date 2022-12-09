package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.CreatorInfoDto;

import kr.co.lovefans.devel.domain.SubListTempDto;
import kr.co.lovefans.devel.domain.Subscr;

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


    private final SubsCustomRepository subsCustomRepository;

    public SubscrService(SubscrRepository subscrRepository, SubCreRepository subCreRepository, SubsCustomRepository subsCustomRepository) {
        this.subscrRepository = subscrRepository;
        this.subCreRepository = subCreRepository;
        this.subsCustomRepository = subsCustomRepository;

    }

    // 비구독 크리에이터
    public List<MemberDto> findAll(Long slvmiseq) {
        return subscrRepository.findAll(slvmiseq);
    }

    // 구독한 크리에이터
    public List<SubCreDto> findCre(Long slvmiseq) {
        return subCreRepository.findCre(slvmiseq);

    }

    // 내 구독자 조회
    public List<MemberDto> findSub(Long slcMiSeq) {
        return subscrRepository.findSub(slcMiSeq);
    }

    public Long join(Subscr subscr) {
        subscrRepository.save(subscr);
        return subscr.getSlvMiSeq();
    }



    public List<SubsSubsListDto> findBySlVmiSeq(Long SlVmiSeq){

        return subsCustomRepository.findBySlVmiSeq(SlVmiSeq);
    }

    public List<SubListTempDto> findSubBySlCMiSeq(Long slCMiSeq) {
        return subscrRepository.findMySub(slCMiSeq);
    }

    public List<SubsSubsListDto> findBySlVmiSeq(Long SlVmiSeq){
        return subsCustomRepository.findBySlVmiSeq(SlVmiSeq);
    }


}
