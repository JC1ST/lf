package kr.co.lovefans.devel.repository;

import kr.co.lovefans.devel.domain.AlarmMsgDto;
import kr.co.lovefans.devel.domain.PushListDto;

import java.util.Optional;

public interface PushMsgRepository {


    PushListDto save(PushListDto pushList);
    Optional<PushListDto> findByPlMiSeq(Long pl_mi_seq);
    Optional<PushListDto> findByPlsMiSeq(Long pl_s_mi_seq);
    Optional<AlarmMsgDto> findByAmSeq(Long am_seq);


}
