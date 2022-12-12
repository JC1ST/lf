package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "pay_info")
@DynamicInsert
public class PayInfoDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "pi_seq")
    private int piSeq;

    @Column(name = "pi_csl_seq")
    private int piCslSeq;

    @Column(name = "pi_mi_seq")
    private int piMiSeq;

    @Column(name = "pi_price")
    private int piPrice;

    @Column(name = "pi_re_price")
    private int piRePrice;

    @Column(name = "pi_state")
    private char piState;

    @Column(name = "pi_card_nm")
    private String piCardNm;

    @Column(name = "pi_card_num")
    private String piCardNum;

    @Column(name = "pi_pay_code")
    private String piPayCode;

    @Column(name = "pi_regdt")
    private Date piRegdt;

    @Column(name = "pi_modidt")
    private Date piModidt;
}
