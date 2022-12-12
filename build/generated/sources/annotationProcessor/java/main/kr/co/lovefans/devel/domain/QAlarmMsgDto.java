package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlarmMsgDto is a Querydsl query type for AlarmMsgDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmMsgDto extends EntityPathBase<AlarmMsgDto> {

    private static final long serialVersionUID = 2002135320L;

    public static final QAlarmMsgDto alarmMsgDto = new QAlarmMsgDto("alarmMsgDto");

    public final StringPath amMsg = createString("amMsg");

    public final NumberPath<Long> amSeq = createNumber("amSeq", Long.class);

    public QAlarmMsgDto(String variable) {
        super(AlarmMsgDto.class, forVariable(variable));
    }

    public QAlarmMsgDto(Path<? extends AlarmMsgDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlarmMsgDto(PathMetadata metadata) {
        super(AlarmMsgDto.class, metadata);
    }

}

