package kr.co.lovefans.devel.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.AlarmMsgDto;
import kr.co.lovefans.devel.domain.PushListDto;
import kr.co.lovefans.devel.domain.QAlarmMsgDto;
import kr.co.lovefans.devel.domain.QPushListDto;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaPushMsgRepository implements PushMsgRepository{



    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaPushMsgRepository(EntityManager em, JPAQueryFactory query) {
        this.em = em;
        this.query = query;
    }

    @Override
    public PushListDto save(PushListDto pushList) {
        em.persist(pushList);
        return pushList;
    }

    @Override
    public Optional<PushListDto> findByPlMiSeq(Long pl_mi_seq) {
        PushListDto push = em.find(PushListDto.class,pl_mi_seq);
        return Optional.ofNullable(push);
    }

    @Override
    public Optional<PushListDto> findByPlsMiSeq(Long pl_s_mi_seq) {
        PushListDto push = em.find(PushListDto.class,pl_s_mi_seq);
        return Optional.ofNullable(push);
    }

    @Override
    public Optional<AlarmMsgDto> findByAmSeq(Long am_seq) {
        AlarmMsgDto alarm = em.find(AlarmMsgDto.class,am_seq);
        return Optional.ofNullable(alarm);
    }

    public List<PushListDto> findAll(Long pl_mi_seq){
        QAlarmMsgDto alarm = QAlarmMsgDto.alarmMsgDto;
        QPushListDto push = QPushListDto.pushListDto;

        List<PushListDto> result = query
                .select(push)
                .from(push)
                .leftJoin(alarm).on(push.plAmSeq.eq(alarm.amSeq))
                .where(push.plMiSeq.eq(pl_mi_seq))
                .fetch();
        return result;


    }

}
