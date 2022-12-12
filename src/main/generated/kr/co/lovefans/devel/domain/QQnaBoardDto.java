package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQnaBoardDto is a Querydsl query type for QnaBoardDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnaBoardDto extends EntityPathBase<QnaBoardDto> {

    private static final long serialVersionUID = -1076249626L;

    public static final QQnaBoardDto qnaBoardDto = new QQnaBoardDto("qnaBoardDto");

    public final NumberPath<Integer> qbMiSeq = createNumber("qbMiSeq", Integer.class);

    public final StringPath qbMsg = createString("qbMsg");

    public final NumberPath<Integer> QbPSeq = createNumber("QbPSeq", Integer.class);

    public final DateTimePath<java.util.Date> qbRegdt = createDateTime("qbRegdt", java.util.Date.class);

    public final DateTimePath<java.util.Date> qbReRegdt = createDateTime("qbReRegdt", java.util.Date.class);

    public final NumberPath<Integer> qbSeq = createNumber("qbSeq", Integer.class);

    public QQnaBoardDto(String variable) {
        super(QnaBoardDto.class, forVariable(variable));
    }

    public QQnaBoardDto(Path<? extends QnaBoardDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQnaBoardDto(PathMetadata metadata) {
        super(QnaBoardDto.class, metadata);
    }

}

