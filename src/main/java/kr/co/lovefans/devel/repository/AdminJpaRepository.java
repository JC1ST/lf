package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.domain.QMemberInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AdminJpaRepository implements AdminRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public AdminJpaRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Page<MemberInfoDto> findAll(Pageable pageable) {
        QMemberInfoDto qMemberInfoDto = QMemberInfoDto.memberInfoDto;

        List<MemberInfoDto> content = query
                .select(Projections.bean(MemberInfoDto.class, qMemberInfoDto.miSeq, qMemberInfoDto.miId, qMemberInfoDto.miNick, qMemberInfoDto.miState, qMemberInfoDto.miKind, qMemberInfoDto.miLevel, qMemberInfoDto.miRegdt))
                .from(qMemberInfoDto)
//                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }

}
