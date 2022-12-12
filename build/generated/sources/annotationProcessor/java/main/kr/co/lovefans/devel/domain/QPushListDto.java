package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPushListDto is a Querydsl query type for PushListDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPushListDto extends EntityPathBase<PushListDto> {

    private static final long serialVersionUID = -2089443152L;

    public static final QPushListDto pushListDto = new QPushListDto("pushListDto");

    public final NumberPath<Long> plAmSeq = createNumber("plAmSeq", Long.class);

    public final NumberPath<Long> plCpSeq = createNumber("plCpSeq", Long.class);

    public final NumberPath<Long> plMiSeq = createNumber("plMiSeq", Long.class);

    public final NumberPath<Long> plRbSeq = createNumber("plRbSeq", Long.class);

    public final DateTimePath<java.util.Date> plRegdt = createDateTime("plRegdt", java.util.Date.class);

    public final NumberPath<Long> plSeq = createNumber("plSeq", Long.class);

    public final NumberPath<Long> plSMiSeq = createNumber("plSMiSeq", Long.class);

    public final ComparablePath<Character> plState = createComparable("plState", Character.class);

    public QPushListDto(String variable) {
        super(PushListDto.class, forVariable(variable));
    }

    public QPushListDto(Path<? extends PushListDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPushListDto(PathMetadata metadata) {
        super(PushListDto.class, metadata);
    }

}

