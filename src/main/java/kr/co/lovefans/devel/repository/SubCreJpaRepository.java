package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.QCreatorInfoDto;
import kr.co.lovefans.devel.domain.QMember;
import kr.co.lovefans.devel.domain.QSubscr;
import kr.co.lovefans.devel.dto.MemberDto;
import kr.co.lovefans.devel.dto.SubCreDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubCreJpaRepository implements SubCreRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public SubCreJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<SubCreDto> findCre() {
        QMember qMember = QMember.member;
        QSubscr qSubscr = QSubscr.subscr;
        QCreatorInfoDto qCreatorInfoDto = QCreatorInfoDto.creatorInfoDto;

        // 수정 필요
        List<SubCreDto> result = query
                .select(Projections.bean(SubCreDto.class, qMember.miSeq, qMember.miNick, qSubscr.slvMiSeq, qSubscr.slcMiSeq, qCreatorInfoDto.ciMiSeq, qCreatorInfoDto.ciPageNm))
                .from(qMember, qCreatorInfoDto, qSubscr)
                .where(qMember.miSeq.eq(qSubscr.slvMiSeq), qSubscr.slvMiSeq.eq(21L), qSubscr.slcMiSeq.eq(2L), qSubscr.slcMiSeq.eq(qCreatorInfoDto.ciMiSeq))

                // 데이터 랜덤 조회
//                .orderBy(Expressions.numberTemplate(Integer.class, "function('rand')").asc())
//                .limit(3)

                .fetch();

        return result;
    }
}
