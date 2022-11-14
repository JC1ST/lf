package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubscr is a Querydsl query type for Subscr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscr extends EntityPathBase<Subscr> {

    private static final long serialVersionUID = 2025481081L;

    public static final QSubscr subscr = new QSubscr("subscr");

    public final NumberPath<Long> slcMiSeq = createNumber("slcMiSeq", Long.class);

    public final NumberPath<Integer> slcslSeq = createNumber("slcslSeq", Integer.class);

    public final DateTimePath<java.util.Date> slModidt = createDateTime("slModidt", java.util.Date.class);

    public final StringPath slMsg = createString("slMsg");

    public final DateTimePath<java.util.Date> slRegdt = createDateTime("slRegdt", java.util.Date.class);

    public final StringPath slState = createString("slState");

    public final NumberPath<Long> slvMiSeq = createNumber("slvMiSeq", Long.class);

    public QSubscr(String variable) {
        super(Subscr.class, forVariable(variable));
    }

    public QSubscr(Path<? extends Subscr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubscr(PathMetadata metadata) {
        super(Subscr.class, metadata);
    }

}

