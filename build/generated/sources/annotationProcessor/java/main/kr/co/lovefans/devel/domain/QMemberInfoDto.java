package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberInfoDto is a Querydsl query type for MemberInfoDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberInfoDto extends EntityPathBase<MemberInfoDto> {

    private static final long serialVersionUID = 1783290080L;

    public static final QMemberInfoDto memberInfoDto = new QMemberInfoDto("memberInfoDto");

    public final StringPath miId = createString("miId");

    public final ComparablePath<Character> miJoinPath = createComparable("miJoinPath", Character.class);

    public final ComparablePath<Character> miKind = createComparable("miKind", Character.class);

    public final NumberPath<Integer> miLevel = createNumber("miLevel", Integer.class);

    public final StringPath miNick = createString("miNick");

    public final StringPath miPhoto = createString("miPhoto");

    public final StringPath miPwd = createString("miPwd");

    public final DateTimePath<java.util.Date> miRegdt = createDateTime("miRegdt", java.util.Date.class);

    public final NumberPath<Long> miSeq = createNumber("miSeq", Long.class);

    public final ComparablePath<Character> miState = createComparable("miState", Character.class);

    public QMemberInfoDto(String variable) {
        super(MemberInfoDto.class, forVariable(variable));
    }

    public QMemberInfoDto(Path<? extends MemberInfoDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberInfoDto(PathMetadata metadata) {
        super(MemberInfoDto.class, metadata);
    }

}

