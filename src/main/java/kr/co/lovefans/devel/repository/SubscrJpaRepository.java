package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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
                .select(Projections.bean(MemberDto.class, qcreatorInfoDto.ciMiSeq, qcreatorInfoDto.ciPageNm, qmember.miNick))
                .from(qcreatorInfoDto, qmember)
                .where(qcreatorInfoDto.ciMiSeq.eq(qmember.miSeq))

                // 데이터 랜덤 조회
                .orderBy(Expressions.numberTemplate(Integer.class, "function('rand')").asc())
                .limit(3)

                .fetch();

        return result;
    }
}
