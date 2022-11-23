package kr.co.lovefans.devel.dto;

import lombok.Data;

@Data
public class MemberDto {

    // 회원번호
    private Long miSeq;

    // 크리에이터 회원번호
    private Long ciMiSeq;

    // 크리에이터 페이지 이름
    private String ciPageNm;

    // 크리에이터 화원번호(sub_list)
    private Long slcMiSeq;

    // 구독자 회원번호(sub_list)
    private Long slvMiSeq;

    // 회원 닉네임
    private String miNick;

    // 프로필 이미지
    private String miPhoto;

    public MemberDto() {

    }

    public MemberDto(Long miSeq, Long ciMiSeq, String ciPageNm, Long slcMiSeq, Long slvMiSeq, String miNick, String miPhoto) {
        this.miSeq = miSeq;
        this.ciMiSeq = ciMiSeq;
        this.ciPageNm = ciPageNm;
        this.slcMiSeq = slcMiSeq;
        this.slvMiSeq = slvMiSeq;
        this.miNick = miNick;
        this.miPhoto = miPhoto;
    }
}
