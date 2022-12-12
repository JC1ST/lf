package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVoteLogDto is a Querydsl query type for VoteLogDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVoteLogDto extends EntityPathBase<VoteLogDto> {

    private static final long serialVersionUID = -1430272612L;

    public static final QVoteLogDto voteLogDto = new QVoteLogDto("voteLogDto");

    public final NumberPath<Integer> vlCpSeq = createNumber("vlCpSeq", Integer.class);

    public final NumberPath<Integer> vlMiSeq = createNumber("vlMiSeq", Integer.class);

    public final NumberPath<Integer> vlRbSeq = createNumber("vlRbSeq", Integer.class);

    public final DateTimePath<java.util.Date> vlRegdt = createDateTime("vlRegdt", java.util.Date.class);

    public final NumberPath<Integer> vlSeq = createNumber("vlSeq", Integer.class);

    public QVoteLogDto(String variable) {
        super(VoteLogDto.class, forVariable(variable));
    }

    public QVoteLogDto(Path<? extends VoteLogDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoteLogDto(PathMetadata metadata) {
        super(VoteLogDto.class, metadata);
    }

}

