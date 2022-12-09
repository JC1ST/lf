package kr.co.lovefans.devel.dto;

import lombok.Data;

@Data
public class SubCreDto {

    // 회원번호
    private Long miSeq;

    // 회원 닉네임
    private String miNick;

    // 프로필 이미지
    private String miPhoto;

    // 크리에이터 화원번호(sub_list)
    private Long slcMiSeq;

    // 구독자 회원번호(sub_list)
    private Long slvMiSeq;

    // 크리에이터 회원번호(create_info)
    private Long ciMiSeq;

    // 크리에이터 페이지 이름(create_info)
    private String ciPageNm;

    // 크리에이터 페이지 커버 사진(create_info)
    private String ciCPhoto;

    public SubCreDto() {

    }

    public SubCreDto(Long miSeq, String miNick, String miPhoto, Long slcMiSeq, Long slvMiSeq, Long ciMiSeq, String ciPageNm, String ciCPhoto) {
        this.miSeq = miSeq;
        this.miNick = miNick;
        this.miPhoto = miPhoto;
        this.slcMiSeq = slcMiSeq;
        this.slvMiSeq = slvMiSeq;
        this.ciMiSeq = ciMiSeq;
        this.ciPageNm = ciPageNm;
        this.ciCPhoto = ciCPhoto;
    }
}
