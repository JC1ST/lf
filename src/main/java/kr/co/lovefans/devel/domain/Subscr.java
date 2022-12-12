package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "sub_list")
@DynamicInsert
public class Subscr {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 크리에이터 회원 고유번호
    @Column(name = "sl_c_mi_seq")
    private Long slcMiSeq;

    // 구독자 회원 고유번호
    @Column(name = "sl_v_mi_seq")
    private Long slvMiSeq;

    // Y:구독, N:구독했으나 크리에이터가 차단시킴
    @Column(name = "sl_state")
    private String slState;

    // 크리에이터가 차단 시 사유 입력
    @Column(name = "sl_msg")
    private String slMsg;

    // 크리에이터가 설정한 요금제 고유키값
    @Column(name = "sl_csl_seq")
    private Integer slcslSeq;

    // 수정 날짜(차단시 사용)
    @Column(name = "sl_modidt")
    private Date slModidt;

    // 구독 등록 날짜
    @Column(name = "sl_regdt")
    private Date slRegdt;
}
