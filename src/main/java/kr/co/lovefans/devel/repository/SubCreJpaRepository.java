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

import static com.querydsl.jpa.JPAExpressions.select;

@Repository
public class SubCreJpaRepository implements SubCreRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public SubCreJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    // 구독한 크리에이터
    @Override
    public List<SubCreDto> findCre(Long slvmiseq) {
        QMember qMember = QMember.member;
        QSubscr qSubscr = QSubscr.subscr;
        QCreatorInfoDto qCreatorInfoDto = QCreatorInfoDto.creatorInfoDto;
        
        List<SubCreDto> result = query
                .select(Projections.bean(SubCreDto.class, qMember.miNick, qCreatorInfoDto.ciMiSeq, qCreatorInfoDto.ciPageNm, qMember.miPhoto, qCreatorInfoDto.ciCPhoto))
                .from(qCreatorInfoDto)
                .join(qMember).on(qCreatorInfoDto.ciMiSeq.eq(qMember.miSeq))
                .where(qCreatorInfoDto.ciMiSeq.in(
                        select(qSubscr.slcMiSeq)
                                .from(qSubscr)
                                .where(qSubscr.slvMiSeq.eq(slvmiseq))
                ))

                .fetch();

        return result;
    }
}
