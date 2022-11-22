package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.QCreatorInfoDto;
import kr.co.lovefans.devel.domain.QCreatorSubLevelDto;
import kr.co.lovefans.devel.domain.QSubListDto;
import kr.co.lovefans.devel.dto.PostDto;
import kr.co.lovefans.devel.dto.SubsSubsListDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubsCustomRepositoryImpl implements SubsCustomRepository{
    private final EntityManager em;

    private final JPAQueryFactory query;

    public SubsCustomRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public List<SubsSubsListDto> findBySlVmiSeq(Long SlVmiSeq) {

        QCreatorSubLevelDto creatorSubLevel = QCreatorSubLevelDto.creatorSubLevelDto;
        QCreatorInfoDto creatorInfo = QCreatorInfoDto.creatorInfoDto;
        QSubListDto subList = QSubListDto.subListDto;

        List<SubsSubsListDto> result = query
                .select(Projections.bean(SubsSubsListDto.class,creatorInfo.ciPageNm,creatorInfo.ciMiSeq,creatorSubLevel.cslNm,creatorSubLevel.cslPrice,subList.subListDtoId.slVMiSeq, subList.slRegdt ))
                .from(creatorInfo)
                .innerJoin(creatorSubLevel).on(creatorInfo.ciMiSeq.eq(creatorSubLevel.cslMiSeq))
                .innerJoin(subList).on(creatorSubLevel.cslMiSeq.eq(subList.subListDtoId.slCMiSeq))
                .where(subList.subListDtoId.slVMiSeq.eq(SlVmiSeq)
                        .and(subList.subListDtoId.slCslSeq.eq(creatorSubLevel.cslSeq)))
                .fetch();

        return result;
    }
}
