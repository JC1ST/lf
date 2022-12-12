package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCreatorInfoDto is a Querydsl query type for CreatorInfoDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCreatorInfoDto extends EntityPathBase<CreatorInfoDto> {

    private static final long serialVersionUID = -182413540L;

    public static final QCreatorInfoDto creatorInfoDto = new QCreatorInfoDto("creatorInfoDto");

    public final StringPath ciBank = createString("ciBank");

    public final StringPath ciBankNum = createString("ciBankNum");

    public final StringPath ciBankUser = createString("ciBankUser");

    public final StringPath ciComment = createString("ciComment");

    public final StringPath ciCPhoto = createString("ciCPhoto");

    public final NumberPath<Long> ciMiSeq = createNumber("ciMiSeq", Long.class);

    public final DateTimePath<java.util.Date> ciModidt = createDateTime("ciModidt", java.util.Date.class);

    public final StringPath ciPageNm = createString("ciPageNm");

    public final StringPath ciPageUrl = createString("ciPageUrl");

    public final StringPath ciPPhoto = createString("ciPPhoto");

    public final ComparablePath<Character> ciPriceKind = createComparable("ciPriceKind", Character.class);

    public final DateTimePath<java.util.Date> ciRegDt = createDateTime("ciRegDt", java.util.Date.class);

    public final ComparablePath<Character> ciState = createComparable("ciState", Character.class);

    public final StringPath ciTheme = createString("ciTheme");

    public QCreatorInfoDto(String variable) {
        super(CreatorInfoDto.class, forVariable(variable));
    }

    public QCreatorInfoDto(Path<? extends CreatorInfoDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCreatorInfoDto(PathMetadata metadata) {
        super(CreatorInfoDto.class, metadata);
    }

}

