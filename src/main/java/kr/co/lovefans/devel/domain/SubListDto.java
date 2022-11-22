package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "sub_list")
@DynamicInsert
@DynamicUpdate
public class SubListDto {


    @EmbeddedId
    private SubListDtoId subListDtoId = new SubListDtoId();

    @Column(name = "sl_msg")
    private String slMsg;

    @Column(name = "sl_modidt")
    private Date slModidt;

    @Column(name = "sl_regdt")
    private Date slRegdt;


    @Column(name = "sl_state")
    private Character slState = 'Y';
}
