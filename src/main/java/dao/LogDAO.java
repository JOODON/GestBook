package dao;

import dto.Log;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LogDAO {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public LogDAO(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource)
                .withTableName("log")
                .usingGeneratedKeyColumns("id");
                //id가 자동으로 입력 되도록 설정해주는것!
    }
    public Long insert(Log log){
        SqlParameterSource params=new BeanPropertySqlParameterSource(log);
        return insertAction.executeAndReturnKey(params).longValue();
    }
}
