package kr.co.lovefans.devel.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.CreatorInfoDto;
import kr.co.lovefans.devel.domain.MemberInfoDto;
import kr.co.lovefans.devel.domain.QCreatorInfoDto;
import kr.co.lovefans.devel.domain.QMember;
import kr.co.lovefans.devel.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
    public List<MemberDto> findAllPlus() {
        QCreatorInfoDto creatorInfoDto = QCreatorInfoDto.creatorInfoDto;
        QMember member = QMember.member;

        List<MemberDto> result = query
                .select(Projections.bean(MemberDto.class, creatorInfoDto.ciMiSeq, creatorInfoDto.ciPageNm, member.miNick))
                .from(creatorInfoDto, member)
                .where(creatorInfoDto.ciMiSeq.eq(member.miSeq))
                .fetch();


        return result;
    }


}
