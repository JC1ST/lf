package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubListDtoId is a Querydsl query type for SubListDtoId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSubListDtoId extends BeanPath<SubListDtoId> {

    private static final long serialVersionUID = 1721585491L;

    public static final QSubListDtoId subListDtoId = new QSubListDtoId("subListDtoId");

    public final NumberPath<Long> slCMiSeq = createNumber("slCMiSeq", Long.class);

    public final NumberPath<Long> slCslSeq = createNumber("slCslSeq", Long.class);

    public final NumberPath<Long> slVMiSeq = createNumber("slVMiSeq", Long.class);

    public QSubListDtoId(String variable) {
        super(SubListDtoId.class, forVariable(variable));
    }

    public QSubListDtoId(Path<? extends SubListDtoId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubListDtoId(PathMetadata metadata) {
        super(SubListDtoId.class, metadata);
    }

}

