package kr.co.lovefans.devel.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Long CpMiSeq;

    private Long SlcMiSeq;
    private Long SlvMiSeq;
    private String CpTitle;
    private String CpContent;
    private String CpTag;
    private String CpLink;
    private Date CpRegdt;

    public PostDto() {
    }

    public PostDto(Long cpMiSeq, Long slcMiSeq, Long slvMiSeq, String cpTitle, String cpContent, String cpTag, String cpLink, Date cpRegdt) {
        CpMiSeq = cpMiSeq;
        SlcMiSeq = slcMiSeq;
        SlvMiSeq = slvMiSeq;
        CpTitle = cpTitle;
        CpContent = cpContent;
        CpTag = cpTag;
        CpLink = cpLink;
        CpRegdt = cpRegdt;
    }
}