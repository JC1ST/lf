package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubListTempDto is a Querydsl query type for SubListTempDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubListTempDto extends EntityPathBase<SubListTempDto> {

    private static final long serialVersionUID = 1766255396L;

    public static final QSubListTempDto subListTempDto = new QSubListTempDto("subListTempDto");

    public final NumberPath<Long> slCMiSeq = createNumber("slCMiSeq", Long.class);

    public final NumberPath<Integer> slCslSeq = createNumber("slCslSeq", Integer.class);

    public final DateTimePath<java.util.Date> slModidt = createDateTime("slModidt", java.util.Date.class);

    public final StringPath slMsg = createString("slMsg");

    public final DateTimePath<java.util.Date> slRegdt = createDateTime("slRegdt", java.util.Date.class);

    public final ComparablePath<Character> slState = createComparable("slState", Character.class);

    public final NumberPath<Long> slVMiSeq = createNumber("slVMiSeq", Long.class);

    public QSubListTempDto(String variable) {
        super(SubListTempDto.class, forVariable(variable));
    }

    public QSubListTempDto(Path<? extends SubListTempDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubListTempDto(PathMetadata metadata) {
        super(SubListTempDto.class, metadata);
    }

}

