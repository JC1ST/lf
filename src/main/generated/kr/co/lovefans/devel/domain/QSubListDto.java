package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubListDto is a Querydsl query type for SubListDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubListDto extends EntityPathBase<SubListDto> {

    private static final long serialVersionUID = 15199256L;

    public static final QSubListDto subListDto = new QSubListDto("subListDto");

    public final NumberPath<Long> slCMiSeq = createNumber("slCMiSeq", Long.class);

    public final NumberPath<Integer> slCslSeq = createNumber("slCslSeq", Integer.class);

    public final DateTimePath<java.util.Date> slModidt = createDateTime("slModidt", java.util.Date.class);

    public final StringPath slMsg = createString("slMsg");

    public final DateTimePath<java.util.Date> slRegdt = createDateTime("slRegdt", java.util.Date.class);

    public final ComparablePath<Character> slState = createComparable("slState", Character.class);

    public final NumberPath<Long> slVMiSeq = createNumber("slVMiSeq", Long.class);

    public QSubListDto(String variable) {
        super(SubListDto.class, forVariable(variable));
    }

    public QSubListDto(Path<? extends SubListDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubListDto(PathMetadata metadata) {
        super(SubListDto.class, metadata);
    }

}

