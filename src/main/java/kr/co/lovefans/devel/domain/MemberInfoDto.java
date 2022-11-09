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
public class MemberInfoDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "mi_seq")
    private Long miSeq;

    @Column(name = "mi_id")
    private String miId;

    @Column(name = "mi_pwd")
    private String miPwd;

    @Column(name = "mi_nick")
    private String miNick;

    @Column(name = "mi_join_path")
    private char miJoinPath;

    @Column(name = "mi_state")
    private char miState;

    @Column(name = "mi_kind")
    private char miKind;

    @Column(name = "mi_level")
    private int miLevel;

    @Column(name = "mi_photo")
    private String miPhoto;

    @Column(name = "mi_regdt")
    private Date miRegdt;
}
