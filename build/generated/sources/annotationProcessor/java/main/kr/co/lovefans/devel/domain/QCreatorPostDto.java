package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCreatorPostDto is a Querydsl query type for CreatorPostDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCreatorPostDto extends EntityPathBase<CreatorPostDto> {

    private static final long serialVersionUID = 1775928810L;

    public static final QCreatorPostDto creatorPostDto = new QCreatorPostDto("creatorPostDto");

    public final StringPath cpContent = createString("cpContent");

    public final StringPath cpFile = createString("cpFile");

    public final StringPath cpImg = createString("cpImg");

    public final ComparablePath<Character> cpKind = createComparable("cpKind", Character.class);

    public final StringPath cpLink = createString("cpLink");

    public final NumberPath<Long> cpMiSeq = createNumber("cpMiSeq", Long.class);

    public final DateTimePath<java.util.Date> cpModidt = createDateTime("cpModidt", java.util.Date.class);

    public final ComparablePath<Character> cpOpen = createComparable("cpOpen", Character.class);

    public final StringPath cpOpenCslSeq = createString("cpOpenCslSeq");

    public final DateTimePath<java.util.Date> cpOpenRegdt = createDateTime("cpOpenRegdt", java.util.Date.class);

    public final DateTimePath<java.util.Date> cpRegdt = createDateTime("cpRegdt", java.util.Date.class);

    public final NumberPath<Long> cpSeq = createNumber("cpSeq", Long.class);

    public final ComparablePath<Character> cpState = createComparable("cpState", Character.class);

    public final StringPath cpTag = createString("cpTag");

    public final StringPath cpTitle = createString("cpTitle");

    public final StringPath cpVideo = createString("cpVideo");

    public final NumberPath<Integer> cpVoteCnt = createNumber("cpVoteCnt", Integer.class);

    public QCreatorPostDto(String variable) {
        super(CreatorPostDto.class, forVariable(variable));
    }

    public QCreatorPostDto(Path<? extends CreatorPostDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCreatorPostDto(PathMetadata metadata) {
        super(CreatorPostDto.class, metadata);
    }

}

