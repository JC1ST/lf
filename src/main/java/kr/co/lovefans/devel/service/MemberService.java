package kr.co.lovefans.devel.service;

import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.Member;
import kr.co.lovefans.devel.repository.CreatorRepository;
import kr.co.lovefans.devel.repository.MemberRepository;
import kr.co.lovefans.devel.repository.SearchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
public class MemberService {

    @Autowired private final SearchResultRepository searchResultRepository;
    @Autowired private final MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    public MemberService(SearchResultRepository searchResultRepository, MemberRepository memberRepository) {
        this.searchResultRepository = searchResultRepository;
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){

        CheckDuplicateMemberNick2(member);
        CheckDuplicateMember2(member);
        EncodingPwd(member);


        /**
         * 시간을 여기서?
         * */
        java.util.Date dt = new java.util.Date();
        java.sql.Date date = new java.sql.Date(dt.getTime());
        member.setMiRegdt(date);
        memberRepository.save(member);
        return member.getMiSeq();
    }

    private void CheckDuplicateMember2(Member member) {
        memberRepository.findByMiId(member.getMiId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 가입된 메일입니다.");
                });
    }

    private void CheckDuplicateMemberNick2(Member member) {
        memberRepository.findByMiNick(member.getMiNick())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용된 닉네임 입니다.");
                });
    }

    private boolean CheckDuplicateMember(Member member) {
        if(memberRepository.findByMiId(member.getMiId()).isPresent()){
            System.out.println("이메일 있음");
            return true;
        }else {
            System.out.println("이메일 사용가능");
            return false;
        }
    }

    private boolean CheckDuplicateMemberNick(Member member) {

        if(memberRepository.findByMiNick(member.getMiNick()).isPresent()){
            System.out.println("닉네임 있음");
            return true;
        }else {
            System.out.println("닉네임 사용가능");
            return false;
        }

    }

    public boolean checkNick(String mi_nick){

        Member member = new Member();
        member.setMiNick(mi_nick);

        return CheckDuplicateMemberNick(member);

    }

    public boolean checkMail(String mi_id){

        Member member = new Member();
        member.setMiId(mi_id);

        return CheckDuplicateMember(member);

    }


    private void EncodingPwd(Member member){
        String pwd = passwordEncoder.encode(member.getMiPwd());
        member.setMiPwd(pwd);
    }

    private Boolean ValidatePwd(Member member){

        Optional<Member> id = memberRepository.findByMiId(member.getMiId());

        if(id.isPresent()){
            boolean valiLogin = passwordEncoder.matches(member.getMiPwd(), id.get().getMiPwd());

            if(valiLogin == true) {
                System.out.println("로그인 성공");
                return true;
            }else {
                System.out.println("비밀번호 틀림");
                return false;
            }
            
        }else{
            System.out.println("아이디없음");
            return false;
        }

        //        id.orElseThrow(()->new IllegalStateException("아이디 존재하지 않음"));
//
//
//
//        if(passwordEncoder.matches(member.getMiPwd(),id.get().getMiPwd())){
//
//            return true;
//        }else {
//
//            return false;
//        }


    }

    public Optional<Member> findOne(Long memberSeq){
        return memberRepository.findByMiSeq(memberSeq);
    }
    public Optional<Member> findById(String id){
        return memberRepository.findByMiId(id);
    }
    public Optional<Member> findByNick(String miNick) {
        return memberRepository.findByMiNick(miNick);
    }

    public Boolean login(Member member){



        return ValidatePwd(member);
    }



    public Page<CreatorInfoDto> searchResult(String keyword,int page){

        return searchResultRepository.findByciPageNmContainingIgnoreCase(keyword,PageRequest.of(page,1,Sort.by(Sort.Direction.DESC,"ciPageNm")));

    }



}
