package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.QCreatorPostDto;
import kr.co.lovefans.devel.domain.QSubListDto;
import kr.co.lovefans.devel.dto.PostDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubsPostCustomRepositoryImpl implements SubsPostCustomRepository{


    private final EntityManager em;
    private final JPAQueryFactory query;

    public SubsPostCustomRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<PostDto> findBySlvmiSeq(Long slvmiseq) {
        QCreatorPostDto post = QCreatorPostDto.creatorPostDto;
        QSubListDto sub = QSubListDto.subListDto;

        List<PostDto> result = query
                .select(Projections.bean(PostDto.class,post.cpMiSeq,post.cpTitle,post.cpContent,post.cpImg,post.cpTag,post.cpLink,post.cpRegdt,sub.subListDtoId.slCMiSeq,sub.subListDtoId.slVMiSeq))
                .from(sub)
                .leftJoin(post).on(post.cpMiSeq.eq(sub.subListDtoId.slCMiSeq))
                .where(sub.subListDtoId.slVMiSeq.eq(slvmiseq))
                .orderBy(post.cpRegdt.desc())
                .limit(5)
                .fetch();

        return result;
    }
}
