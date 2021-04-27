package com.atguigu.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
class SpringbootWeb01ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_employee", Long.class);
        log.info("查询到的数量: {}",aLong);
    }

    @Test
    void redisTest(){
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        stringValueOperations.append("zhangsan","23");
        String res = stringValueOperations.get("zhangsan");
        log.info("值是：{}",res);
    }

}
