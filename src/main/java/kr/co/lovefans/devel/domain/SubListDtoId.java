package kr.co.lovefans.devel.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class SubListDtoId implements Serializable {

    @Column(name = "sl_c_mi_seq")
    private Long slCMiSeq;

    @Column(name = "sl_v_mi_seq")
    private Long slVMiSeq;

    @Column(name = "sl_csl_seq")
    private Long slCslSeq;

}


