package kr.co.lovefans.devel.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lovefans.devel.domain.CreatorPostDto;

import kr.co.lovefans.devel.domain.QCreatorPostDto;
import kr.co.lovefans.devel.domain.QSubListDto;
import kr.co.lovefans.devel.dto.PostDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public class JpaCreatorPostRepository implements CreatorPostRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;


    public JpaCreatorPostRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public CreatorPostDto save(CreatorPostDto creatorPostDto) {
        return null;
    }

    @Override
    public List<CreatorPostDto> findBycpMiSeq(Long cpMiSeq) {
        return null;
    }

    @Override
    public Slice<CreatorPostDto> findSliceBycpMiSeq(Long cpMiSeq, Pageable pageable) {
        return null;
    }


}
