package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMsgListDto is a Querydsl query type for MsgListDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMsgListDto extends EntityPathBase<MsgListDto> {

    private static final long serialVersionUID = 638338999L;

    public static final QMsgListDto msgListDto = new QMsgListDto("msgListDto");

    public final StringPath mlMsg = createString("mlMsg");

    public final NumberPath<Long> mlRcvMiSeq = createNumber("mlRcvMiSeq", Long.class);

    public final DateTimePath<java.util.Date> mlRegdt = createDateTime("mlRegdt", java.util.Date.class);

    public final NumberPath<Long> mlSendMiSeq = createNumber("mlSendMiSeq", Long.class);

    public final NumberPath<Long> mlSeq = createNumber("mlSeq", Long.class);

    public final ComparablePath<Character> mlState = createComparable("mlState", Character.class);

    public final DateTimePath<java.util.Date> mlVRegdt = createDateTime("mlVRegdt", java.util.Date.class);

    public QMsgListDto(String variable) {
        super(MsgListDto.class, forVariable(variable));
    }

    public QMsgListDto(Path<? extends MsgListDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMsgListDto(PathMetadata metadata) {
        super(MsgListDto.class, metadata);
    }

}

