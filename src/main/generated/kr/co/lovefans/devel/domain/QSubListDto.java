package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubListDto is a Querydsl query type for SubListDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubListDto extends EntityPathBase<SubListDto> {

    private static final long serialVersionUID = 15199256L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubListDto subListDto = new QSubListDto("subListDto");

    public final DateTimePath<java.util.Date> slModidt = createDateTime("slModidt", java.util.Date.class);

    public final StringPath slMsg = createString("slMsg");

    public final DateTimePath<java.util.Date> slRegdt = createDateTime("slRegdt", java.util.Date.class);

    public final ComparablePath<Character> slState = createComparable("slState", Character.class);

    public final QSubListDtoId subListDtoId;

    public QSubListDto(String variable) {
        this(SubListDto.class, forVariable(variable), INITS);
    }

    public QSubListDto(Path<? extends SubListDto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubListDto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubListDto(PathMetadata metadata, PathInits inits) {
        this(SubListDto.class, metadata, inits);
    }

    public QSubListDto(Class<? extends SubListDto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subListDtoId = inits.isInitialized("subListDtoId") ? new QSubListDtoId(forProperty("subListDtoId")) : null;
    }

}

