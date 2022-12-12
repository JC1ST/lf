package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qzzzzzzz is a Querydsl query type for zzzzzzz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qzzzzzzz extends EntityPathBase<zzzzzzz> {

    private static final long serialVersionUID = -1216149469L;

    public static final Qzzzzzzz zzzzzzz = new Qzzzzzzz("zzzzzzz");

    public final StringPath ciBank = createString("ciBank");

    public final StringPath ciBankNum = createString("ciBankNum");

    public final StringPath ciBankUser = createString("ciBankUser");

    public final StringPath ciComment = createString("ciComment");

    public final StringPath ciCPhoto = createString("ciCPhoto");

    public final NumberPath<Integer> ciMiSeq = createNumber("ciMiSeq", Integer.class);

    public final DateTimePath<java.util.Date> ciModidt = createDateTime("ciModidt", java.util.Date.class);

    public final StringPath ciPageNm = createString("ciPageNm");

    public final StringPath ciPageUrl = createString("ciPageUrl");

    public final StringPath ciPPhoto = createString("ciPPhoto");

    public final ComparablePath<Character> ciPriceKind = createComparable("ciPriceKind", Character.class);

    public final DateTimePath<java.util.Date> ciRegDt = createDateTime("ciRegDt", java.util.Date.class);

    public final ComparablePath<Character> ciState = createComparable("ciState", Character.class);

    public final StringPath ciTheme = createString("ciTheme");

    public Qzzzzzzz(String variable) {
        super(zzzzzzz.class, forVariable(variable));
    }

    public Qzzzzzzz(Path<? extends zzzzzzz> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qzzzzzzz(PathMetadata metadata) {
        super(zzzzzzz.class, metadata);
    }

}

