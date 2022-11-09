package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "qna_board")
@DynamicInsert
public class QnaBoardDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "qb_seq")
    private int qbSeq;

    @Column(name = "qb_mi_seq")
    private int qbMiSeq;

    @Column(name = "qb_p_seq")
    private int QbPSeq;

    @Column(name = "qb_msg")
    private String qbMsg;

    @Column(name = "qb_regdt")
    private Date qbRegdt;

    @Column(name = "qb_re_regdt")
    private Date qbReRegdt;
}
