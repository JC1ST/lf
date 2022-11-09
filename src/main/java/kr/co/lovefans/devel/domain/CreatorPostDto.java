package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "create_post")
@DynamicInsert
public class CreatorPostDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_seq")
    private Long cpSeq;

    @Column(name = "cp_mi_seq")
    private Long cpMiSeq;

    @Column(name = "cp_state")
    private char cpState;

    @Column(name = "cp_kind")
    private char cpKind;

    @Column(name = "cp_open")
    private char cpOpen;

    @Column(name = "cp_open_csl_seq")
    private String cpOpenCslSeq;

    @Column(name = "cp_title")
    private String cpTitle;

    @Column(name = "cp_content")
    private String cpContent;

    @Column(name = "cp_file")
    private String cpFile;

    @Column(name = "cp_img")
    private String cpImg;

    @Column(name = "cp_tag")
    private String cpTag;

    @Column(name = "cp_video")
    private String cpVideo;

    @Column(name = "cp_link")
    private String cpLink;

    @Column(name = "cp_regdt")
    private Date cpRegdt;

    @Column(name = "cp_modidt")
    private Date cpModidt;

    @Column(name = "cp_open_regdt")
    private Date cpOpenRegdt;

    @Column(name = "cp_vote_cnt")
    private int cpVoteCnt;
}
