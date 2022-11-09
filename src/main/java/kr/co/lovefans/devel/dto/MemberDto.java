package kr.co.lovefans.devel.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Long ciMiSeq;
    private String ciPageNm;
    private String miNick;

    public MemberDto() {

    }

    public MemberDto(Long ciMiSeq, String ciPageNm, String miNick) {
        this.ciMiSeq = ciMiSeq;
        this.ciPageNm = ciPageNm;
        this.miNick = miNick;
    }
}
