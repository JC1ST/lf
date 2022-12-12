package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "push_list")
@DynamicInsert
public class PushListDto {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pl_seq")
    private Long plSeq;

    @Column(name = "pl_mi_seq")
    private Long plMiSeq;

    @Column(name = "pl_s_mi_seq")
    private Long plSMiSeq;

    @Column(name = "pl_cp_seq")
    private Long plCpSeq;

    @Column(name = "pl_rb_seq")
    private Long plRbSeq;

    @Column(name = "pl_state")
    private char plState;

    @Column(name = "pl_am_seq")
    private Long plAmSeq;

    @Column(name = "pl_regdt")
    private Date plRegdt;
}
