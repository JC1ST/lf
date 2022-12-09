package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.CreatorSubLevelDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.repository.CreateSubLevelRepository;
import kr.co.lovefans.devel.repository.CreatorRepository;
import kr.co.lovefans.devel.repository.JpaCreatorRepository;
import kr.co.lovefans.devel.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CreatorService {

    @Autowired private final CreateSubLevelRepository createSubLevelRepository;
    @Autowired private final CreatorRepository creatorRepository;
    @Autowired private final MemberRepository memberRepository;

    public CreatorService(CreateSubLevelRepository createSubLevelRepository, CreatorRepository creatorRepository, MemberRepository memberRepository) {
        this.createSubLevelRepository = createSubLevelRepository;

        this.creatorRepository = creatorRepository;
        this.memberRepository = memberRepository;
    }

    public Long join(CreatorInfoDto creatorInfo) {
        validateDuplicatePageName(creatorInfo);
        creatorRepository.save(creatorInfo);
        return creatorInfo.getCiMiSeq();
    }

    private void validateDuplicatePageName(CreatorInfoDto creatorInfo) {
        creatorRepository.findByPageNm(creatorInfo.getCiPageNm())
                .ifPresent(c -> {
                    throw new IllegalStateException("이미 존재하는 페이지입니다.");
                });
    }

    public List<CreatorInfoDto> findCreatorInfo() {
        return creatorRepository.findAll();
    }

    public Optional<CreatorInfoDto> findOne(Long ciMiSeq) {
        return creatorRepository.findBySeq(ciMiSeq);
    }

    public Optional<MemberInfoDto> findOneMemInfo(Long miSeq) {
        return creatorRepository.findMemInfoBySeq(miSeq);
    }


    public List<MemberDto> findAllPlus(){
        return creatorRepository.findAllPlus();
    }

    public Member modify(Member member) {
        Member checkByNick = memberRepository.findByMiNick(member.getMiNick()).get();
        Member checkById = memberRepository.findByMiId(member.getMiId()).get();
        if(checkByNick != null) {
            return checkByNick;
        } else if(checkById != null) {
            return checkById;
        }

        return memberRepository.save(member);
    }

    public CreatorInfoDto modify(CreatorInfoDto creator) {

        return creatorRepository.save(creator);
    }

    public List<CreatorSubLevelDto> findByCslMiSeq(Long CslMiSeq){

        return createSubLevelRepository.findByCslMiSeq(CslMiSeq);
    }

    public Optional<CreatorSubLevelDto> findByCslSeq(Long CslSeq){

        return createSubLevelRepository.findByCslSeq(CslSeq);
    }





}


