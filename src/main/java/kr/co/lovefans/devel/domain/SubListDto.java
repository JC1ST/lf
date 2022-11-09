package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "sub_list")
@DynamicInsert
public class SubListDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "sl_c_mi_seq")
    private Long slCMiSeq;

    @Column(name = "sl_v_mi_seq")
    private Long slVMiSeq;

    @Column(name = "sl_state")
    private char slState;

    @Column(name = "sl_msg")
    private String slMsg;

    @Column(name = "sl_csl_seq")
    private int slCslSeq;

    @Column(name = "sl_modidt")
    private Date slModidt;

    @Column(name = "sl_regdt")
    private Date slRegdt;
}
