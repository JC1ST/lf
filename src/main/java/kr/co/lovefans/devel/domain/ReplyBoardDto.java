package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "reply_board")
@DynamicInsert
public class ReplyBoardDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "rb_seq")
    private int rbSeq;

    @Column(name = "rb_cp_seq")
    private int rbCpSeq;

    @Column(name = "rb_mi_seq")
    private int rbMiSeq;

    @Column(name = "rb_p_seq")
    private int rbPSeq;

    @Column(name = "rb_state")
    private char rbState;

    @Column(name = "rb_regdt")
    private Date rbRegdt;

    @Column(name = "rb_vote_cnt")
    private int rbVoteCnt;
}
