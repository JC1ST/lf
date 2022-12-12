package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "create_info")
@DynamicInsert
public class CreatorInfoDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci_mi_seq")
    private Long ciMiSeq;        // 회원고유키

    @Column(name = "ci_state")
    private char ciState;       // 상태

    @Column(name = "ci_page_nm")
    private String ciPageNm;    // 페이지 이름

    @Column(name = "ci_page_url")
    private String ciPageUrl;   // 페이지 url

    @Column(name = "ci_theme")
    private String ciTheme;     // 주제

    @Column(name = "ci_p_photo")
    private String ciPPhoto;    // 프로필 사진 경로

    @Column(name = "ci_c_photo")
    private String ciCPhoto;    // 페이지 커버 사진 경로

    @Column(name = "ci_comment")
    private String ciComment;   // 페이지 인사말

    @Column(name = "ci_bank")
    private String ciBank;      // 수입지급 계좌은행

    @Column(name = "ci_bank_num")
    private String ciBankNum;   // 수입지급 계좌번호

    @Column(name = "ci_bank_user")
    private String ciBankUser;  // 수입지급 계좌명의자

    @Column(name = "ci_price_kind")
    private char ciPriceKind;   // 크리에이터 요금제

    @Column(name = "ci_modidt")
    private Date ciModidt;      // 최종 변경일

    @Column(name = "ci_regdt")
    private Date ciRegDt;       // 신청일
}
