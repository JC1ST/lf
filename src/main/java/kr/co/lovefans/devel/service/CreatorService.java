package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.repository.CreatorRepository;
import kr.co.lovefans.devel.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CreatorService {

    @Autowired private final CreatorRepository creatorRepository;
    @Autowired private final MemberRepository memberRepository;

    public CreatorService(CreatorRepository creatorRepository, MemberRepository memberRepository) {

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

}
