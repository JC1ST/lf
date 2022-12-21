package kr.co.lovefans.devel.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.*;
import kr.co.lovefans.devel.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Repository
public class JpaCreatorRepository implements CreatorRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;


    public JpaCreatorRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public CreatorInfoDto save(CreatorInfoDto creatorInfo) {
        em.persist(creatorInfo);

        return creatorInfo;
    }

    @Override
    public Optional<CreatorInfoDto> findBySeq(Long ciMiSeq) {
        CreatorInfoDto creatorInfo = em.find(CreatorInfoDto.class, ciMiSeq);

        return Optional.ofNullable(creatorInfo);
    }

    @Override
    public Optional<MemberInfoDto> findMemInfoBySeq(Long miSeq) {
        MemberInfoDto memberInfo = em.find(MemberInfoDto.class, miSeq);

        return Optional.ofNullable(memberInfo);
    }


    @Override
    public Optional<CreatorInfoDto> findByPageNm(String ciPageNm) {
        List<CreatorInfoDto> result = em.createQuery("select c from CreatorInfoDto c where c.ciPageNm = :ciPageNm", CreatorInfoDto.class)
                .setParameter("ciPageNm", ciPageNm)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<CreatorInfoDto> findAll() {
        return em.createQuery("select c from CreatorInfoDto c", CreatorInfoDto.class)
                .getResultList();
    }

    @Override
    public List<CreatorPostDto> findAllPost(Long cpMiSeq) {
        QCreatorPostDto qCreatorPostDto = QCreatorPostDto.creatorPostDto;

        List<CreatorPostDto> result = query
                .select(Projections.bean(CreatorPostDto.class, qCreatorPostDto.cpTitle, qCreatorPostDto.cpContent, qCreatorPostDto.cpImg, qCreatorPostDto.cpRegdt))
                .from(qCreatorPostDto)
                .where(qCreatorPostDto.cpMiSeq.eq(cpMiSeq))
                
                // 최신 날짜 순 포스트 3개만 조회
                .orderBy(qCreatorPostDto.cpRegdt.desc())
                .limit(3)

                .fetch();

        return result;

    }

    @Override
    public List<MemberDto> findAllPlus() {
        QCreatorInfoDto creatorInfoDto = QCreatorInfoDto.creatorInfoDto;
        QMember member = QMember.member;

        List<MemberDto> result = query
                .select(Projections.bean(MemberDto.class, creatorInfoDto.ciMiSeq, creatorInfoDto.ciPageNm, member.miNick, member.miPhoto))
                .from(creatorInfoDto, member)
                .where(creatorInfoDto.ciMiSeq.eq(member.miSeq))

                // 데이터 랜덤 조회
                .orderBy(Expressions.numberTemplate(Integer.class, "function('rand')").asc())
                .limit(3)

                .fetch();


        return result;
    }
}
