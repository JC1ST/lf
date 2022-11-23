package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.dto.SubCreDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.querydsl.jpa.JPAExpressions.select;

@Repository
public class SubscrJpaRepository implements SubscrRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public SubscrJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    // 비구독 크리에이터
    @Override
    public List<MemberDto> findAll(Long slvmiseq) {
        QMember qMember = QMember.member;
        QSubscr qSubscr = QSubscr.subscr;
        QCreatorInfoDto qCreatorInfoDto = QCreatorInfoDto.creatorInfoDto;

        List<MemberDto> result = query
                .select(Projections.bean(MemberDto.class, qCreatorInfoDto.ciMiSeq, qCreatorInfoDto.ciPageNm, qMember.miNick, qMember.miPhoto))
                .from(qCreatorInfoDto)
                .join(qMember).on(qCreatorInfoDto.ciMiSeq.eq(qMember.miSeq))
                .where(qCreatorInfoDto.ciMiSeq.notIn(
                        select(qSubscr.slcMiSeq)
                                .from(qSubscr)
                                .where(qSubscr.slvMiSeq.eq(slvmiseq))
                ))

                // 데이터 랜덤 조회
                .orderBy(Expressions.numberTemplate(Integer.class, "function('rand')").asc())
                .limit(3)

                .fetch();

        return result;
    }
}
