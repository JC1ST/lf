package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "mem_info")
@DynamicInsert
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mi_seq")
    private Long miSeq;
    /**
     *  id = email
     * */
    @Column(name = "mi_id")
    private String miId;

    @Column(name = "mi_pwd")
    private String miPwd;
    @Column(name = "mi_nick")
    private String miNick;
    @Column(name = "mi_join_path")
    private String miJoinPath;
    @Column(name = "mi_state")
    private String miState;
    @Column(name = "mi_kind")
    private String miKind;
    @Column(name = "mi_level")
    private Integer miLevel;
    @Column(name = "mi_photo")
    private String miPhoto;
    @Column(name = "mi_regdt")
    private Date miRegdt;


}
