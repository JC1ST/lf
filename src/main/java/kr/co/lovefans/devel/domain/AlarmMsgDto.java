package kr.co.lovefans.devel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity// JPA과 관리하는 Entity임을 선언
@Getter
@Setter
@Table(name = "alarm_msg")
@DynamicInsert
public class AlarmMsgDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "am_seq")
    private Long amSeq;        // 알람 번호

    @Column(name = "am_msg")
    private String amMsg;       // 알람
}
