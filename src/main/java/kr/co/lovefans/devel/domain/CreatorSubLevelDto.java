package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "create_sub_level")
@DynamicInsert
public class CreatorSubLevelDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csl_seq")
    private Long cslSeq;

    @Column(name = "csl_mi_seq")
    private Long cslMiSeq;

    @Column(name = "csl_nm")
    private String cslNm;

    @Column(name = "csl_price")
    private int cslPrice;

    @Column(name = "csl_comment")
    private String cslComment;

    @Column(name = "csl_prefer")
    private String cslPrefer;

    @Column(name = "csl_modidt")
    private Date cslModidt;

    @Column(name = "csl_regdt")
    private Date cslRegdt;
}
