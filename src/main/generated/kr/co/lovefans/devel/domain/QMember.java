package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1839241265L;

    public static final QMember member = new QMember("member1");

    public final StringPath miId = createString("miId");

    public final StringPath miJoinPath = createString("miJoinPath");

    public final StringPath miKind = createString("miKind");

    public final NumberPath<Integer> miLevel = createNumber("miLevel", Integer.class);

    public final StringPath miNick = createString("miNick");

    public final StringPath miPhoto = createString("miPhoto");

    public final StringPath miPwd = createString("miPwd");

    public final DateTimePath<java.util.Date> miRegdt = createDateTime("miRegdt", java.util.Date.class);

    public final NumberPath<Long> miSeq = createNumber("miSeq", Long.class);

    public final StringPath miState = createString("miState");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

