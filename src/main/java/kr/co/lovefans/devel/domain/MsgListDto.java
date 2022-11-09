package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "msg_list")
@DynamicInsert
public class MsgListDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ml_seq")
    private Long mlSeq;

    @Column(name = "ml_send_mi_seq")
    private Long mlSendMiSeq;

    @Column(name = "ml_rcv_mi_seq")
    private Long mlRcvMiSeq;

    @Column(name = "ml_msg")
    private String mlMsg;

    @Column(name = "ml_state")
    private char mlState;

    @Column(name = "ml_regdt")
    private Date mlRegdt;

    @Column(name = "ml_v_regdt")
    private Date mlVRegdt;
}
