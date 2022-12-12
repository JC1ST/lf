package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReplyBoardDto is a Querydsl query type for ReplyBoardDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplyBoardDto extends EntityPathBase<ReplyBoardDto> {

    private static final long serialVersionUID = 1009296556L;

    public static final QReplyBoardDto replyBoardDto = new QReplyBoardDto("replyBoardDto");

    public final NumberPath<Integer> rbCpSeq = createNumber("rbCpSeq", Integer.class);

    public final NumberPath<Integer> rbMiSeq = createNumber("rbMiSeq", Integer.class);

    public final NumberPath<Integer> rbPSeq = createNumber("rbPSeq", Integer.class);

    public final DateTimePath<java.util.Date> rbRegdt = createDateTime("rbRegdt", java.util.Date.class);

    public final NumberPath<Integer> rbSeq = createNumber("rbSeq", Integer.class);

    public final ComparablePath<Character> rbState = createComparable("rbState", Character.class);

    public final NumberPath<Integer> rbVoteCnt = createNumber("rbVoteCnt", Integer.class);

    public QReplyBoardDto(String variable) {
        super(ReplyBoardDto.class, forVariable(variable));
    }

    public QReplyBoardDto(Path<? extends ReplyBoardDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReplyBoardDto(PathMetadata metadata) {
        super(ReplyBoardDto.class, metadata);
    }

}

