package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "mem_info")
@DynamicInsert
public class zzzzzzz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ci_mi_seq")
    private int ciMiSeq;

    @Column(name = "ci_state")
    private char ciState;

    @Column(name = "ci_page_nm")
    private String ciPageNm;

    @Column(name = "ci_page_url")
    private String ciPageUrl;

    @Column(name = "ci_theme")
    private String ciTheme;

    @Column(name = "ci_p_photo")
    private String ciPPhoto;

    @Column(name = "ci_c_photo")
    private String ciCPhoto;

    @Column(name = "ci_comment")
    private String ciComment;

    @Column(name = "ci_bank")
    private String ciBank;

    @Column(name = "ci_bank_num")
    private String ciBankNum;

    @Column(name = "ci_bank_user")
    private String ciBankUser;

    @Column(name = "ci_price_kind")
    private char ciPriceKind;

    @Column(name = "ci_modidt")
    private Date ciModidt;

    @Column(name = "ci_regdt")
    private Date ciRegDt;
}
