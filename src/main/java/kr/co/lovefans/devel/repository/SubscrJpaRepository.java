package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public class SubscrJpaRepository implements SubscrRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public SubscrJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<MemberDto> findAll() {
        QCreatorInfoDto qcreatorInfoDto = QCreatorInfoDto.creatorInfoDto;
        QMember qmember = QMember.member;

        List<MemberDto> result = query
                .select(Projections.bean(MemberDto.class, qcreatorInfoDto.ciMiSeq, qcreatorInfoDto.ciPageNm, qmember.miNick, qmember.miPhoto))
                .from(qcreatorInfoDto, qmember)
                .where(qcreatorInfoDto.ciMiSeq.eq(qmember.miSeq))

                // 데이터 랜덤 조회
                .orderBy(Expressions.numberTemplate(Integer.class, "function('rand')").asc())
                .limit(3)

                .fetch();

        return result;
    }

    @Override
    public List<SubListDto> findMySub(Long slCMiSeq) {
        List<SubListDto> result = em.createQuery("select s from SubListDto s where s.slCMiSeq = :slCMiSeq", SubListDto.class)
                .setParameter("slCMiSeq", slCMiSeq)
                .getResultList();

        return result;
    }
}
