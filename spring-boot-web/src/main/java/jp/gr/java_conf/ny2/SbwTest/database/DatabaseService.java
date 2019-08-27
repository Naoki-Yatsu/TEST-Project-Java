package jp.gr.java_conf.ny2.SbwTest.database;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private  Server server;
    
    @PostConstruct
    public void init() throws Exception {
        String sql = "SELECT 1";
        SqlParameterSource param = new MapSqlParameterSource();
        Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);

        System.out.println("Result = " + result);
        
        System.out.println("Server = " + server);
    }

}
