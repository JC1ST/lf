package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "vote_log")
@DynamicInsert
public class VoteLogDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "vl_seq")
    private int vlSeq;

    @Column(name = "vl_cp_seq")
    private int vlCpSeq;

    @Column(name = "vl_rb_seq")
    private int vlRbSeq;

    @Column(name = "vl_mi_seq")
    private int vlMiSeq;

    @Column(name = "vl_regdt")
    private Date vlRegdt;
}
