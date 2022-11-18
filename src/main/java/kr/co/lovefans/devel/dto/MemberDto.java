package kr.co.lovefans.devel.dto;

import lombok.Data;

@Data
public class MemberDto {

    // 크리에이터 회원번호
    private Long ciMiSeq;

    // 크리에이터 페이지 이름
    private String ciPageNm;

    // 회원 닉네임
    private String miNick;

    // 프로필 이미지
    private String miPhoto;

    public MemberDto() {

    }

    public MemberDto(Long ciMiSeq, String ciPageNm, String miNick, String miPhoto) {
        this.ciMiSeq = ciMiSeq;
        this.ciPageNm = ciPageNm;
        this.miNick = miNick;
        this.miPhoto = miPhoto;
    }
}
