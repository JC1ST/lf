package kr.co.lovefans.devel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayInfoDto is a Querydsl query type for PayInfoDto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayInfoDto extends EntityPathBase<PayInfoDto> {

    private static final long serialVersionUID = 1292502688L;

    public static final QPayInfoDto payInfoDto = new QPayInfoDto("payInfoDto");

    public final StringPath piCardNm = createString("piCardNm");

    public final StringPath piCardNum = createString("piCardNum");

    public final NumberPath<Integer> piCslSeq = createNumber("piCslSeq", Integer.class);

    public final NumberPath<Integer> piMiSeq = createNumber("piMiSeq", Integer.class);

    public final DateTimePath<java.util.Date> piModidt = createDateTime("piModidt", java.util.Date.class);

    public final StringPath piPayCode = createString("piPayCode");

    public final NumberPath<Integer> piPrice = createNumber("piPrice", Integer.class);

    public final DateTimePath<java.util.Date> piRegdt = createDateTime("piRegdt", java.util.Date.class);

    public final NumberPath<Integer> piRePrice = createNumber("piRePrice", Integer.class);

    public final NumberPath<Integer> piSeq = createNumber("piSeq", Integer.class);

    public final ComparablePath<Character> piState = createComparable("piState", Character.class);

    public QPayInfoDto(String variable) {
        super(PayInfoDto.class, forVariable(variable));
    }

    public QPayInfoDto(Path<? extends PayInfoDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayInfoDto(PathMetadata metadata) {
        super(PayInfoDto.class, metadata);
    }

}

