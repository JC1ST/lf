package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCreatorSubLevelDto is a Querydsl query type for CreatorSubLevelDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCreatorSubLevelDto extends EntityPathBase<CreatorSubLevelDto> {

    private static final long serialVersionUID = -2057671322L;

    public static final QCreatorSubLevelDto creatorSubLevelDto = new QCreatorSubLevelDto("creatorSubLevelDto");

    public final StringPath cslComment = createString("cslComment");

    public final NumberPath<Long> cslMiSeq = createNumber("cslMiSeq", Long.class);

    public final DateTimePath<java.util.Date> cslModidt = createDateTime("cslModidt", java.util.Date.class);

    public final StringPath cslNm = createString("cslNm");

    public final StringPath cslPrefer = createString("cslPrefer");

    public final NumberPath<Integer> cslPrice = createNumber("cslPrice", Integer.class);

    public final DateTimePath<java.util.Date> cslRegdt = createDateTime("cslRegdt", java.util.Date.class);

    public final NumberPath<Long> cslSeq = createNumber("cslSeq", Long.class);

    public QCreatorSubLevelDto(String variable) {
        super(CreatorSubLevelDto.class, forVariable(variable));
    }

    public QCreatorSubLevelDto(Path<? extends CreatorSubLevelDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCreatorSubLevelDto(PathMetadata metadata) {
        super(CreatorSubLevelDto.class, metadata);
    }

}

