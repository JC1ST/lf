//package kr.co.lovefans.devel.repository;
//
//import kr.co.lovefans.devel.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//public class JdbcTemplateMemberRepository implements MemberRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Member save(Member member) {
//
//        java.util.Date dt = new java.util.Date();
//        java.sql.Date date = new java.sql.Date(dt.getTime());
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("mem_info").usingGeneratedKeyColumns("mi_seq");
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("mi_id",member.getMi_id());
//        parameters.put("mi_pwd",member.getMi_pwd());
//        parameters.put("mi_nick",member.getMi_nick());
//        parameters.put("mi_join_path","L");
//        parameters.put("mi_state","1");
//        parameters.put("mi_kind","V");
//        parameters.put("mi_level",1);
//        parameters.put("mi_regdt",date);
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        member.setMi_seq(key.longValue());
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findBySeq(Long mi_seq) {
//
//        List<Member> result = jdbcTemplate.query("select * from mem_info where mi_seq = ?", memberRowMapper(), mi_seq);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findById(String mi_id) {
//        List<Member> result = jdbcTemplate.query("select * from mem_info where mi_id = ?", memberRowMapper(), mi_id);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findByNick(String mi_nick) {
//        List<Member> result = jdbcTemplate.query("select * from mem_info where mi_nick = ?", memberRowMapper(), mi_nick);
//        return result.stream().findAny();
//    }
//
//    public List<Member> findAll(){
//        return jdbcTemplate.query("select * from mem_info",memberRowMapper());
//    }
//
//    private RowMapper<Member> memberRowMapper(){
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Member member = new Member();
//                member.setMi_seq(rs.getLong("mi_seq"));
//                member.setMi_id(rs.getString("mi_id"));
//                return member;
//            }
//        };
//    }
//
//}
